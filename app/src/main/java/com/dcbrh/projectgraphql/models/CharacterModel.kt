package com.dcbrh.projectgraphql.models

import com.dcbrh.projectgraphql.util.LifeStatus

data class CharacterModel (
    val id: String,
    val name: String,
    val status: LifeStatus,
    val species: String,
    val image: String,
    val lastLocation: String,
    val firstSeen: String
)