package fr.vinwin.miniprojet.backend

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn (ViewModelComponent :: class)
abstract class EstimatorBackendModule {
    @Binds
    abstract fun bindEstimatorBackend ( fakeBackendImpl: FakeBackendImpl): EstimatorBackend
}