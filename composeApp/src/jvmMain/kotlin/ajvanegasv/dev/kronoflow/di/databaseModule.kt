package ajvanegasv.dev.kronoflow.di

import ajvanegasv.dev.kronoflow.data.datasource.local.dao.SpaceDao
import ajvanegasv.dev.kronoflow.data.datasource.local.dao.TaskDao
import org.koin.dsl.module

val databaseModule = module {
    factory { SpaceDao() }
    factory { TaskDao() }
}