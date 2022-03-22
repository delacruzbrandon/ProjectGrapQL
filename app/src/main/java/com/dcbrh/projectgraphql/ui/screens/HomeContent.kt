package com.dcbrh.projectgraphql.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dcbrh.projectgraphql.R
import com.dcbrh.projectgraphql.models.CharacterModel
import com.dcbrh.projectgraphql.ui.theme.*
import com.dcbrh.projectgraphql.util.Constants.FIRST_SEEN_CAPTION
import com.dcbrh.projectgraphql.util.Constants.LAST_LOCATION_CAPTION
import com.dcbrh.projectgraphql.util.LifeStatus

@Composable
fun HomeContent() {

    PreviewHomeContent()
}

@Composable
fun CharacterCardList(
    characterList: List<CharacterModel>
) {
    LazyColumn {
        items(
            items = characterList,
            key = {character -> character.id}
        ) { character ->
            CharacterCard(character = character)
        }
    }
}

@Composable
fun CharacterCard(
    character: CharacterModel
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(CHARACTER_CARD_CORNERS),
        elevation = CHARACTER_CARD_ELEVATION
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                modifier = Modifier.size(CHARACTER_CARD_IMAGE_SIZE),
                painter = rememberImagePainter(character.image),
                contentDescription = "CharacterCardImage"
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Column(
                ) {
                    Text(
                        modifier = Modifier,
                        text = character.name,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.CharacterCardTextColor,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f),
                            contentAlignment = Alignment.CenterStart,
                        ) {
                            Canvas(
                                modifier = Modifier
                                    .size(CHARACTER_CARD_LIFE_STATUS_SIZE)
                            ) {
                                drawCircle(
                                    color = LifeStatus.Alive.color
                                )
                            }
                        }
                        Text(
                            modifier = Modifier.weight(19f),
                            text = "${character.status} - ${character.species}",
                            style = MaterialTheme.typography.subtitle2,
                            color = MaterialTheme.colors.CharacterCardTextColor,
                            maxLines = 1
                        )

                    }
                }

                val textDetailsModifier = Modifier
                    .fillMaxWidth()

                CharacterCardTextDetails(
                    modifier = textDetailsModifier,
                    captionText = LAST_LOCATION_CAPTION,
                    subtitleText = character.lastLocation
                )

                CharacterCardTextDetails(
                    modifier = textDetailsModifier,
                    captionText = FIRST_SEEN_CAPTION,
                    subtitleText = character.firstSeen
                )
            }
        }
    }
}

@Composable
fun CharacterCardTextDetails(
    modifier: Modifier,
    captionText: String,
    subtitleText: String
) {
    Column(
        modifier = modifier
    ) {
        CharacterCardTextCaption(captionText = captionText)
        CharacterCardTextSubtitle(subtitleText = subtitleText)
    }
}

@Composable
fun CharacterCardTextCaption(captionText: String) {
    Text(
        text = captionText,
        color = MaterialTheme.colors.CharacterCardTextCaptionColor,
        style = MaterialTheme.typography.caption
    )
}

@Composable
fun CharacterCardTextSubtitle(subtitleText: String) {
    Text(
        text = subtitleText,
        color = MaterialTheme.colors.CharacterCardTextColor,
        style = MaterialTheme.typography.subtitle1
    )
}


@Composable
@Preview
private fun PreviewHomeContent() {

    val characterModel = CharacterModel(
        1,
        "Rick",
        LifeStatus.Alive,
        "Human",
        "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        "Citadel of Ricks",
        "Earth (C-137)"
    )

    val characterList = listOf(
        characterModel,
        characterModel,
        characterModel,
        characterModel,
        characterModel,
        characterModel,
        characterModel,
        characterModel,
        characterModel
    )

    CharacterCardList(
        characterList = characterList
    )
}