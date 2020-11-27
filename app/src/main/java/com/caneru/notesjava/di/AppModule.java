package com.caneru.notesjava.di;

import android.app.Application;
import android.content.Context;

import com.caneru.notesjava.service.LocalStore;
import com.caneru.notesjava.service.SharedPrefsLocalStore;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public LocalStore provideLocalStore(Application context) {
        return new SharedPrefsLocalStore(context.getSharedPreferences("notes", Context.MODE_PRIVATE));
    }

}
