package di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by cmason on 08/02/2018.
 */
@Module class ContextModule(context: Context)
{
    @Provides
    fun provideContext(context: Context): Context = context.applicationContext
}