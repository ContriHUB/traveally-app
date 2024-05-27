package com.ash.traveally.models

data class Blog(
    val id: Long,
    val user: User,
    val city: String,
    val country: String,
    val title: String,
    val introduction: String,
    val description: String,
    val likes: Int,
    val placePhoto: String,
    val time: Long
)

val blogItem = Blog(
    id = 123L,
    user = userItem,
    city = "Paris",
    country = "France",
    title = "Exploring Paradise: \nA Journey Through Maui, USA",
    introduction = "Nestled in the heart of the Pacific Ocean, amidst the vast expanse of the Hawaiian archipelago, lies a gem that captures the essence of paradise like no other – Maui. Renowned for its stunning beaches, lush landscapes, and vibrant culture, Maui beckons travelers from around the globe to immerse themselves in its beauty and tranquility. Join me as we embark on a journey through this enchanting island, discovering its hidden treasures and experiencing the essence of aloha.",
    description = "Day 1: Arrival in Paradise\n" +
            "Our adventure begins as we touch down at Kahului Airport, greeted by the warm tropical breeze and the scent of plumeria flowers. After picking up our rental car, we head to our accommodation, eager to start exploring. Maui offers a range of lodging options, from luxurious beachfront resorts to cozy vacation rentals tucked away in the countryside. We settle into our home away from home, ready to dive into all that this island paradise has to offer.\n" +
            "\n" +
            "Day 2: Road to Hana\n" +
            "No trip to Maui is complete without a journey along the iconic Road to Hana. Winding along the northeastern coastline, this scenic drive is a feast for the senses, with lush rainforests, cascading waterfalls, and panoramic ocean views at every turn. We make frequent stops to explore hidden beaches, swim in freshwater pools, and marvel at the beauty of nature. Highlights include the Wai'anapanapa State Park, where we hike to a black sand beach, and the Seven Sacred Pools at Ohe'o Gulch, where we take a refreshing dip beneath a series of cascading waterfalls.\n" +
            "\n" +
            "Day 3: Haleakalā National Park\n" +
            "Rising over 10,000 feet above sea level, Haleakalā Crater is a geological wonder that offers breathtaking vistas and otherworldly landscapes. We wake before dawn to witness the sunrise from the summit, where the spectacle of colors painting the sky is nothing short of awe-inspiring. As the day unfolds, we explore the park's network of hiking trails, marveling at the unique flora and fauna that call this volcanic wilderness home. A visit to the Haleakalā Visitor Center provides insight into the cultural and ecological significance of this sacred place, leaving us with a deep appreciation for Maui's natural heritage.\n" +
            "\n" +
            "Day 4: Beach Bliss\n" +
            "Maui is renowned for its pristine beaches, and today is dedicated to soaking up the sun and surf. Whether you're a seasoned surfer or a beachcomber seeking solitude, Maui's coastline offers something for everyone. We spend the day lounging on the golden sands of Ka'anapali Beach, where crystal-clear waters beckon us to swim and snorkel among vibrant coral reefs. For those seeking adventure, activities such as paddleboarding, kayaking, and parasailing are readily available, providing thrills against a backdrop of tropical paradise.\n" +
            "\n" +
            "Day 5: Cultural Immersion\n" +
            "To truly understand Maui, one must delve into its rich cultural heritage and traditions. We venture into the historic town of Lahaina, once a bustling whaling port and now a hub of art, culture, and commerce. Strolling along Front Street, we encounter a vibrant mix of galleries, boutiques, and restaurants, each offering a taste of Maui's unique charm. We visit the Baldwin Home Museum to learn about the island's plantation era and explore the Lahaina Heritage Museum to gain insight into its storied past. As the sun sets, we gather for a traditional Hawaiian luau, complete with music, dance, and feasting, celebrating the spirit of aloha that defines Maui's cultural identity.\n" +
            "\n" +
            "Day 6: Farewell to Paradise\n" +
            "As our time in Maui draws to a close, we reflect on the memories we've made and the beauty we've experienced. From the rugged coastline of the Road to Hana to the towering peaks of Haleakalā, Maui has captured our hearts and sparked a longing to return. As we bid farewell to this island paradise, we carry with us the spirit of aloha – a reminder to live with love, respect, and gratitude for the world around us.\n" +
            "\n" +
            "Conclusion:\n" +
            "Our journey through Maui has been nothing short of magical, a testament to the island's enduring allure and natural splendor. Whether you're seeking adventure, relaxation, or cultural immersion, Maui offers an experience like no other, inviting travelers to discover the true meaning of paradise. As we depart this island oasis, we do so with a sense of gratitude and reverence, knowing that Maui will forever hold a special place in our hearts. Until we meet again, aloha nui loa – farewell with much love.",
    likes = 100,
    placePhoto = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true",
    time = System.currentTimeMillis()
)