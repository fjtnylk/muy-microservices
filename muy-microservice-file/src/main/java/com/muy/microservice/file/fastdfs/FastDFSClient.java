package com.muy.microservice.file.fastdfs;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Objects;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

/**
 * Created by yanglikai on 2018/1/29.
 */
public class FastDFSClient {
  private static final Logger log = LoggerFactory.getLogger(FastDFSClient.class);

  public static final String SPLIT_GROUP_NAME_AND_FILENAME_SEPERATOR = "/";

  private static TrackerClient trackerClient;
  private static TrackerServer trackerServer;
  private static StorageClient storageClient;
  private static StorageServer storageServer;

  static {
    try {
      String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
      ClientGlobal.init(filePath);
      TrackerGroup tg = new TrackerGroup(new InetSocketAddress[]{new InetSocketAddress("10.67.52.211", 22122)});
      trackerClient = new TrackerClient(tg);
      trackerServer = trackerClient.getConnection();

      storageServer = trackerClient.getStoreStorage(trackerServer);
      storageClient = new StorageClient(trackerServer, storageServer);
    } catch (Exception e) {
      log.error("FastDFS Client Init Fail!", e);
    }
  }

  public static String upload(FastDFSFile file) {
    log.info("File Name: " + file.getName() + "File Length:" + file.getContent().length);

    NameValuePair[] metaList = new NameValuePair[1];
    metaList[0] = new NameValuePair("author", file.getAuthor());

    try {
      String[] parts = storageClient.upload_file(file.getGroupName(), file.getContent(), file.getExt(), metaList);
      String fileId = "";
      if (Objects.isNull(parts) == false) {
        fileId = parts[0] + SPLIT_GROUP_NAME_AND_FILENAME_SEPERATOR + parts[1];
      }
      InetSocketAddress inetSockAddr = trackerServer.getInetSocketAddress();
      String file_url = "http://" + inetSockAddr.getAddress().getHostAddress();
      if (ClientGlobal.DEFAULT_HTTP_TRACKER_HTTP_PORT != 80) {
        file_url += ":" + ClientGlobal.DEFAULT_HTTP_TRACKER_HTTP_PORT;
      }
      file_url += "/" + fileId;
      int timestamp;
      String token;
      if (ClientGlobal.DEFAULT_HTTP_ANTI_STEAL_TOKEN) {
        timestamp = (int) (System.currentTimeMillis() / 1000);
        token = ProtoCommon.getToken(fileId, timestamp, ClientGlobal.g_secret_key);
        file_url += "?token=" + token + "&timestamp=" + timestamp;
      }
      return file_url;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public static void main(String[] args) {
    try {
      String groupName = "com.muy.b2b";
      String fileName = new ClassPathResource("商品库存_20180116142434.xlsx").getFile().getAbsolutePath();
      String ext = "xlsx";
      byte[] bytes = FileCopyUtils.copyToByteArray(new File(fileName));

      FastDFSFile file = new FastDFSFile(groupName, fileName, bytes, ext);

      String token = upload(file);

      System.out.println(token);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
