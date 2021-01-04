package com.luis.luisgoogleproject.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/4  16:39
 * desc   :
 */
@Database(entities = {Student.class}, version = 5, exportSchema = true)
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase INSTANCE;
    public static synchronized StudentDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(), StudentDatabase.class, "student_database")
                    .fallbackToDestructiveMigration()//防止出现升级失败导致应用程序crash，但是会重新创建数据库表，所有的数据会丢失。
                    .addMigrations(MIGRATION_2_3)
                    .addMigrations(MIGRATION_4_5)
                    .build();
        }
        return INSTANCE;
    }

    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
                database.execSQL("ALTER TABLE student "+"ADD COLUMN tell TEXT");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student "+"ADD COLUMN tell TEXT");
        }
    };

    static final Migration MIGRATION_4_5 = new Migration(4,5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //删除tell字段，没有办法直接删除一列，可以通过以下四步完成删除某一列
            //1. 创建一个新表temp,只设定想要的字段
            database.execSQL("CREATE TABLE studentTemp "+
                    "( id  INTEGER "+" PRIMARY KEY NOT NULL ,"+
                    " name TEXT ,"+
                    " age INTEGER "+" NOT NULL"+
                    " ) "
            );
            //2. 将原表中的数据复制过来
            database.execSQL(" INSERT INTO studentTemp (id,name,age) " +
                    "SELECT id,name,age  FROM student "
            );

            //3. 删除原表
            database.execSQL(" DROP TABLE student ");
            //4.将新表temp更名为student
            database.execSQL(" ALTER  TABLE studentTemp  RENAME to student");

        }
    };

    public abstract StudentDao getStudentDao();
}
