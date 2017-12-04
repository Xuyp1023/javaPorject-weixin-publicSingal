package com.xyp.thread.reentractlock;

public interface UpdateInterface {

    // 查找version
    public int findVersionByid(Long id);

    // 更新data
    public int updateData(Long id, int version, int data);

    public int findDataByid(Long id);
    /**
     *  @Update("UPDATE castest SET DATA = #{data}, version = #{version} +1 where  id = #{id} and version = #{version} ")
    int updateData(@Param("id") Long id, @Param("version") int version, @Param("data") int data);
     */

}
