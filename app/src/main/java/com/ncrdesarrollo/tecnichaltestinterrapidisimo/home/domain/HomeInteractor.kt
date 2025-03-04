package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain

import android.content.Context
import android.content.pm.PackageInfo
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.model.UserData
import javax.inject.Inject

class HomeInteractor @Inject constructor(private val repository: IHomeRepository, private val context: Context) : IHomeInteractor {
    override suspend fun getVersionMessage(): String {

        var message = ""

        val pInfo: PackageInfo =
            context.packageManager.getPackageInfo("com.ncrdesarrollo.tecnichaltestinterrapidisimo", 0)
        val localVersion = pInfo.versionCode

        if (repository.getVersion() != null) {
            message = if (localVersion < repository.getVersion()!!){
                "La versión local es Inferior"
            } else {
                "La versión local es Superior"
            }
        }


        return message
    }

    override suspend fun login(): UserData {
        return repository.login()
    }
}
