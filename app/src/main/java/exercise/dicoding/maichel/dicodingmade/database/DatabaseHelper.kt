package exercise.dicoding.maichel.dicodingmade.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DatabaseHelper(ctx:Context):ManagedSQLiteOpenHelper(ctx, "FavoritesMovies.db", null, 1) {
    companion object{
        private var instance: DatabaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseHelper{
            if(instance == null){
                instance = DatabaseHelper(ctx.applicationContext)
            }
            return instance as DatabaseHelper
        }
    }
}

