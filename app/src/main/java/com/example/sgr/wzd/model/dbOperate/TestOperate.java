package com.example.sgr.wzd.model.dbOperate;

import android.content.Context;
import com.example.sgr.wzd.model.dbBean.Test;
import com.example.sgr.wzd.model.dbHelp.DbManager;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Data：2018/1/23/023-16:01
 * By  沈国荣
 * Description: 操作类 示例
 * 调用示例：TestOperate.insertData(this,test);
 */
public class TestOperate {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, Test stu) {
        DbManager.getDaoSession(context).getTestDao().insert(stu);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<Test> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getTestDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param student
     */
    public static void saveData(Context context, Test student) {
        DbManager.getDaoSession(context).getTestDao().save(student);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param student 删除具体内容
     */
    public static void deleteData(Context context, Test student) {
        DbManager.getDaoSession(context).getTestDao().delete(student);
    }

/*    *//**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     *//*
    public static void deleteByKeyData(Context context, long id) {
        DbManager.getDaoSession(context).getTestDao().deleteByKey(id);
    }*/

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getTestDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param context
     * @param student
     */
    public static void updateData(Context context, Test student) {
        DbManager.getDaoSession(context).getTestDao().update(student);
    }

    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<Test> queryAll(Context context) {
        QueryBuilder<Test> builder = DbManager.getDaoSession(context).getTestDao().queryBuilder();

        return builder.build().list();
    }

 /*   *//**
     * 根据id，其他的字段类似
     *
     * @param context
     * @param id
     * @return
     *//*
    public static List<Student> queryForId(Context context, long id) {
        QueryBuilder<Student> builder = DbManager.getDaoSession(context).getTestDao().queryBuilder();
        *//**
         * 返回当前id的数据集合,当然where(这里面可以有多组，做为条件);
         * 这里build.list()；与where(StudentDao.Properties.Id.eq(id)).list()结果是一样的；
         * 在QueryBuilder类中list()方法return build().list();
         *
         *//*
        // Query<Student> build = builder.where(StudentDao.Properties.Id.eq(id)).build();
        // List<Student> list = build.list();
        return builder.where(TestDao.Properties.Id.eq(id)).list();
    }*/


}