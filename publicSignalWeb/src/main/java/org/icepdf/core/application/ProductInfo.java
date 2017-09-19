package org.icepdf.core.application;

public class ProductInfo {
    public static String COMPANY = "ICEsoft Technologies, Inc.";
    public static String PRODUCT = "ICEpdf-pro";
    public static String PRIMARY = "6";
    public static String SECONDARY = "2";
    public static String TERTIARY = "5";
    public static String RELEASE_TYPE = "";
    public static String BUILD_NO = "172";
    public static String REVISION = "";

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n");
      localStringBuilder.append(COMPANY);
      localStringBuilder.append("\n");
      localStringBuilder.append(PRODUCT);
      localStringBuilder.append(" ");
      localStringBuilder.append(PRIMARY);
      localStringBuilder.append(".");
      localStringBuilder.append(SECONDARY);
      localStringBuilder.append(".");
      localStringBuilder.append(TERTIARY);
      localStringBuilder.append(" ");
      localStringBuilder.append(RELEASE_TYPE);
      localStringBuilder.append("\n");
      localStringBuilder.append("Build number: ");
      localStringBuilder.append(BUILD_NO);
      localStringBuilder.append("\n");
      localStringBuilder.append("Revision: ");
      localStringBuilder.append(REVISION);
      localStringBuilder.append("\n");
      return "";
    }

    public String getVersion()
    {
      //StringBuilder localStringBuilder = new StringBuilder();
      //localStringBuilder.append(PRIMARY);
      //localStringBuilder.append(".");
      //localStringBuilder.append(SECONDARY);
      //localStringBuilder.append(".");
      //localStringBuilder.append(TERTIARY);
      //localStringBuilder.append(" ");
      //localStringBuilder.append(RELEASE_TYPE);
      return "";
    }

    public static void main(String[] paramArrayOfString)
    {
      ProductInfo localProductInfo = new ProductInfo();
      System.out.println(localProductInfo.toString());
    }

}
