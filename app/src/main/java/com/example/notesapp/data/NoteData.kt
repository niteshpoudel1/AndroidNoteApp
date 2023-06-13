package com.example.notesapp.data

import com.example.notesapp.model.Note

class NoteDataSource {
    fun loadNotes() : List<Note>{
        return listOf(
            Note(title = "My Day", noteContent = "Dear Diary, Today was a great day! I went to the park with my friends and we played on the swings and slides. We also played tag and hide-and-seek. I had so much fun that I forgot all about my homework!"),
            Note(title = "How to write notes", noteContent = "Find a quiet place to write. You might want to write in your bedroom or in a special spot in your backyard."),
            Note(title = "Journaling is fun", noteContent = "This is just one example of a journal entry that a regular kid might write. Journal entries can be about anything, from what happened during the day to what the kid is thinking or feeling. Journaling can be a great way for kids to express themselves and to process their thoughts and feelings. It can also be a fun way to keep track of memories and to look back on them later."),
            Note(title = "Joke of the day", noteContent = "Why did the scarecrow win an award? He was outstanding in his field."),
            Note(title = "Nepal", noteContent = "Nepal is home to eight of the world's ten highest mountains, including Mount Everest, the tallest mountain in the world."),
            Note(title = "Facts about Nepal", noteContent = "Nepal is a member of the United Nations, the South Asian Association for Regional Cooperation, and the Non-Aligned Movement."),
            Note(title = "Tourism and the state of countries", noteContent = "Nepal is a popular tourist destination, known for its stunning mountain scenery, rich culture, and friendly people."),
            Note(title = "Trekking day", noteContent = "Nepal is a popular destination for trekking and mountaineering, and is home to a number of trekking trails, including the Annapurna Circuit and the Everest Base Camp Trek."),
            Note(title = "Home is where the heart is", noteContent = "I've traveled the world, but there's no place like home Nepal is where my heart belongs I've seen the Taj Mahal and the Great Wall of China, But nothing compares to the beauty of Nepal."),
            Note(title = "New day new beginning", noteContent = "Today, I woke up at 7am and had a cup of coffee. Then, I worked on a few projects for my clients. I also wrote a blog post about the benefits of using a large language model. In the afternoon, I took a break to go for a walk in the park. After that, I worked on some personal projects. I finished the day by watching a movie with my friends."),
        )
    }
}