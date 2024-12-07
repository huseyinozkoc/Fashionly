package com.example.fashionly.data.repository

import com.example.fashionly.data.source.local.MainRoomDB
import com.example.fashionly.data.source.remote.MainService
import com.example.fashionly.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService,
    private val mainRoomDB: MainRoomDB,
) : MainRepository