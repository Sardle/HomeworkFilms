package com.example.homeworkfilms.data

import com.example.homeworkfilms.data.models.UiItemResponse
import kotlinx.coroutines.delay
import javax.inject.Inject

class Server @Inject constructor() {

    suspend fun getFilms(): List<List<UiItemResponse>> {
        delay(3000)
        return listOf(
            listOf(
                UiItemResponse(
                    1, "https://b1.filmpro.ru/c/807442.jpg",
                    "9.1", "Побег из шоушека", false, "Побег из шоушека топ",
                    "Комедия"
                ),
                UiItemResponse(
                    2,
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/854c1f17-f2b3-401b-aa04-b5647707c9e7/1920x",
                    "8.4",
                    "Титаник",
                    true,
                    "грустно",
                    "Комедия"
                ),
                UiItemResponse(
                    3, "https://www.film.ru/sites/default/files/movies/posters/5558835-851147.jpg",
                    "8.1", "Бен-Гур", true, "не смотрел",
                    "Комедия"
                ),
                UiItemResponse(
                    4,
                    "https://media.kg-portal.ru/movies/e/englishpatient/posters/englishpatient_1.jpg",
                    "7.8",
                    "Английский пациент",
                    true,
                    "крутой фильм",
                    "Комедия"
                ),
                UiItemResponse(
                    5, "https://www.kino-teatr.ru/movie/posters/big/4/29964.jpg",
                    "8.3", "Однажды в Америке", false, "сигма",
                    "Комедия"
                )
            ),
            listOf(
                UiItemResponse(
                    6,
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/df080df4-6725-4d8f-a79e-dc497543aff0/1920x",
                    "8.7",
                    "Леон",
                    false,
                    "не смотрел леон",
                    "Боевик"
                ), UiItemResponse(
                    7, "https://b1.filmpro.ru/c/87928.jpg",
                    "8.2", "Амадей", true, "тоже не смотрел"
                ), UiItemResponse(
                    8,
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/e0d164bb-68a4-4f16-bc2a-3994b4df36d4/1920x",
                    "8.1",
                    "Ганди",
                    true,
                    "интерестный",
                    "Боевик"
                ),
                UiItemResponse(
                    9, "https://b1.filmpro.ru/c/10103.jpg",
                    "8.3", "Американская история X", false, "опять не смотрел",
                    "Боевик"
                ),
                UiItemResponse(
                    10,
                    "https://upload.wikimedia.org/wikipedia/ru/thumb/1/16/Slumdog_Millionaire_poster.jpg/203px-Slumdog_Millionaire_poster.jpg",
                    "7.7",
                    "Миллионер из трущоб",
                    true,
                    "очень интересно",
                    "Боевик"
                )
            ),
            listOf(
                UiItemResponse(
                    11, "https://b1.filmpro.ru/c/77153.jpg",
                    "8.8", "Список Шиндлера", true, "очень грустный",
                    "Драма"
                ),
                UiItemResponse(
                    12, "https://www.kino-teatr.ru/movie/posters/big/1/22041.jpg",
                    "8.9", "Форрест Гамп", true, "поучительный",
                    "Драма"
                ),
                UiItemResponse(
                    13,
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/226a2544-74f7-4d29-92f2-48c0155c4852/1920x",
                    "8.0",
                    "Город бога",
                    false,
                    "опять же не смотрел",
                    "Драма"
                ),
                UiItemResponse(
                    14,
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/61c2b142-5a06-444b-a3ed-944a765d7d75/1920x",
                    "7.8",
                    "Большой Лебовски",
                    false,
                    "очень крутой",
                    "Драма"
                ),
                UiItemResponse(
                    15,
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/24a1df5a-2037-481c-baa4-ed20b104d827/1920x",
                    "8.2",
                    "Лицо со шрамом",
                    false,
                    "классика",
                    "Драма"
                )
            )
        )
    }
}