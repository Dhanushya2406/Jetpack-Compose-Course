package com.dhanu.trailproject.superheros

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dhanu.trailproject.R

data class Heros(
    @StringRes val herosName: Int,
    @StringRes val herosDescription: Int,
    @DrawableRes val herosImage: Int
)


object HeroesRepository {
    val heroes = listOf(
        Heros(
            herosName = R.string.hero1,
            herosDescription = R.string.description1,
            herosImage = R.drawable.android_superhero1
        ),
        Heros(
            herosName = R.string.hero2,
            herosDescription = R.string.description2,
            herosImage = R.drawable.android_superhero2
        ),
        Heros(
            herosName = R.string.hero3,
            herosDescription = R.string.description3,
            herosImage = R.drawable.android_superhero3
        ),
        Heros(
            herosName = R.string.hero4,
            herosDescription = R.string.description4,
            herosImage = R.drawable.android_superhero4
        ),
        Heros(
            herosName = R.string.hero5,
            herosDescription = R.string.description5,
            herosImage = R.drawable.android_superhero5
        ),
        Heros(
            herosName = R.string.hero6,
            herosDescription = R.string.description6,
            herosImage = R.drawable.android_superhero6
        ),
        Heros(
            herosName = R.string.hero1,
            herosDescription = R.string.description1,
            herosImage = R.drawable.android_superhero1
        ),
        Heros(
            herosName = R.string.hero2,
            herosDescription = R.string.description2,
            herosImage = R.drawable.android_superhero2
        ),
        Heros(
            herosName = R.string.hero3,
            herosDescription = R.string.description3,
            herosImage = R.drawable.android_superhero3
        ),
        Heros(
            herosName = R.string.hero4,
            herosDescription = R.string.description4,
            herosImage = R.drawable.android_superhero4
        ),
        Heros(
            herosName = R.string.hero5,
            herosDescription = R.string.description5,
            herosImage = R.drawable.android_superhero5
        ),
        Heros(
            herosName = R.string.hero6,
            herosDescription = R.string.description6,
            herosImage = R.drawable.android_superhero6
        )
    )
}
