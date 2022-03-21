package com.dcbrh.projectgraphql.models

import com.dcbrh.projectgraphql.LifeStatus
import java.util.*

data class CharacterModel (
    val id: Int,
    val name: String,
    val status: LifeStatus,
    val species: String,
    val image: String,
    val origin: OriginModel,
    val location: LocationModel
)