package ajvanegasv.dev.kronoflow.di

import ajvanegasv.dev.kronoflow.data.datasource.local.dao.SpaceDao
import ajvanegasv.dev.kronoflow.data.repository.SpaceRepositoryExposed
import ajvanegasv.dev.kronoflow.domain.SpaceRepository
import org.koin.dsl.module

val databaseModule = module {
    factory<SpaceDao> { SpaceDao() }
    factory<SpaceRepository> { SpaceRepositoryExposed(get<SpaceDao>()) }
}