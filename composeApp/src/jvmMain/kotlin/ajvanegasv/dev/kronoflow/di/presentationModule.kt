package ajvanegasv.dev.kronoflow.di

import ajvanegasv.dev.kronoflow.domain.SpaceRepository
import ajvanegasv.dev.kronoflow.presentation.SpaceViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { SpaceViewModel(get<SpaceRepository>()) }
}