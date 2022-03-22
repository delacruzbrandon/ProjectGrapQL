package com.dcbrh.projectgraphql.models

import com.dcbrh.projectgraphql.util.LifeStatus

data class CharacterProfileModel (
    val id: Int,
    val name: String,
    val status: LifeStatus,
    val species: String,
    val image: String,
    val origin: OriginModel,
    val location: LocationModel,
    val episode: List<EpisodeModel>
)