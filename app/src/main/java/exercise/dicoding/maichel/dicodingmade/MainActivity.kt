package exercise.dicoding.maichel.dicodingmade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import exercise.dicoding.maichel.dicodingmade.adapter.UpcomingFilmAdapter
import exercise.dicoding.maichel.dicodingmade.adapter.ViewPagerAdapter
import exercise.dicoding.maichel.dicodingmade.model.ModelUpcomingFilm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vw_films.adapter = ViewPagerAdapter(supportFragmentManager)
        tab_main.setupWithViewPager(vw_films)
//        val listFilm = listOf(
//            ModelUpcomingFilm(title = "Shazam", actors = "Zachary Levi, Asher Angel, Mark Strong Jack Dylan Grazer, Djimon Hounsou",
//                directors = "David Sandberg", img_source = "https://upload.wikimedia.org/wikipedia/en/thumb/6/60/Shazam%21_theatrical_poster.jpg/220px-Shazam%21_theatrical_poster.jpg",
//                synopsis =  "Billy Batson, seorang anak yatim berusia 14 tahun" +
//                        "yang bermasalah yang tinggal di Philadelphia, diatur untuk pindah ke rumah asuh baru - " +
//                        "yang ketujuh berturut-turut - dengan keluarga Vazquez dan lima anak asuh lainnya. " +
//                        "Suatu hari, Billy naik mobil subway dan menemukan dirinya diangkut ke dunia yang berbeda di mana " +
//                        "penyihir kuno memberinya kekuatan", status = "Ongoing"),
//
//            ModelUpcomingFilm(title = "Aladdin", actors = "Will Smith, Mena Massoud, Naomi Scott, Marwan Kenzari, Navid Negahban, Nasim Pedrad, Billy Magnussen",
//                directors = "Guy Ritchie", img_source = "https://web3.21cineplex.com/movie-images/19ALAN.jpg",
//                synopsis =  "Aladdin, seorang anak jalanan yang jatuh " +
//                        "cinta pada seorang putri. Dengan perbedaan kasta dan harta, Aladdin pun berusaha mencari jalan " +
//                        "agar bisa mejadi seorang pangeran, tak disangka ia menemukan lampu dengan jin di dalamnya. " +
//                        "Aladdin pun menggunakan lampu untuk mengubah dirinya menjadi seorang pangeran untuk " +
//                        "memenangkan hati Putri Jasmine, tapi Wazir jahat juga mengejar lampu tersebut untuk " +
//                        "menguasai kerajaan.", status = "Ongoing"),
//
//            ModelUpcomingFilm(title = "Captain Marvell", actors = "Brie Larson, Samuel L. Jackson, Ben Mendelsohn, Djimon Hounsou, Lee Pace, Lashana Lynch, " +
//                    "Gemma Chanm Annette Bening, Clark Gregg, Jude Law",
//                directors = "Anna Boden, Ryan Fleck", img_source = "https://upload.wikimedia.org/wikipedia/id/thumb/d/d0/CaptainMarvelPoster2019.jpg/250px-CaptainMarvelPoster2019.jpg",
//                synopsis =  "Captain Marvel adalah superhero wanita dari " +
//                        "Marvel yang mempunyai banyak kekuatan setara seperti Superman. Superhero yang bernama " +
//                        "Carol Danvers ini awalnya merupakan seorang pilot luar angkasa, konon ia mendapatakan " +
//                        "kekuatan supernya dari bangsa alien.", status = "Ongoing"),
//
//            ModelUpcomingFilm(title = "Single Part 2", actors = "",
//                directors = "Raditya Dika", img_source = "https://web3.21cineplex.com/movie-images/09SPA2.jpg",
//                synopsis =  "Ebi, menuju usia 30 tahun dan masih Single." +
//                        " Menuju usia 30 tahun tanpa pernah Pacaran." +
//                        " Sekarang Ebi bertekad sebelum ulang tahunnya yang ke 30 ia harus melepaskan status " +
//                        "Singlenya. Ia harus punya pacar. Walau Ebi sama sekali tidak tahu bagaimana caranya.", status = "Upcoming"),
//
//            ModelUpcomingFilm(title = "Spider-Man: Into the Spider-Verse", actors = "Shameik Moore\n" +
//                    "Jake Johnson\n" +
//                    "Hailee Steinfeld\n" +
//                    "Mahershala Ali\n" +
//                    "Brian Tyree Henry\n" +
//                    "Lily Tomlin\n" +
//                    "Luna Lauren Velez\n" +
//                    "John Mulaney\n" +
//                    "Kimiko Glenn\n" +
//                    "Nicolas Cage\n" +
//                    "Liev Schreiber",
//                directors = "Bob Persichetti, Peter Ramsey, Rodney Rothman", img_source = "https://upload.wikimedia.org/wikipedia/id/b/b8/Spider-Man_Into_the_Spider-Verse_%282018_poster%29.png",
//                synopsis =  "Miles Morales adalah seorang remaja yang mengagumi Spider-Man, dan berjuang memenuhi ekspektasi orangtuanya." +
//                        " Ayahnya, petugas kepolisian, Jefferson Davis, melihat Spider-Man sebagai sebuah ancaman. Sepulang sekolah Miles " +
//                        "diam-diam mengunjungi pamannya, Aaron Davis, yang membawa Miles ke stasiun kereta bawah tanah yang tidak digunakan " +
//                        "tempat ia bisa melukis grafiti. Sementara di sana, Miles digigit laba-laba radioaktif dan mengembangkan kemampuan " +
//                        "seperti laba-laba. " +
//                        "Mencari laba-laba yang menggigitnya, Miles kemudian kembali ke stasiun dan tanpa sengaja menemukan akselerator partikel yang dibangun oleh Wilson Fisk, yang ingin mengakses alam semesta paralel dan menemukan versi alternatif dari istri dan putranya yang meninggal dalam kecelakaan mobil. Spider-Man tiba untuk menonaktifkan akselerator dan melawan mahluk super lain yang berada di pihak Fisk, " +
//                        "Green Goblin dan Prowler. Spider-Man menemukan bahwa Miles memiliki kemampuan yang serupa, tetapi terluka parah oleh " +
//                        "ledakan selama pertempuran yang membunuh Green Goblin. Spider-Man memberi Miles USB untuk menonaktifkan akselerator dan " +
//                        "memperingatkan bahwa mesin itu dapat menghancurkan kota jika dihidupkan lagi. Miles kemudian menyaksikan Fisk membunuh " +
//                        "Spider-Man dengan ngeri sebelum melarikan diri.", status = "Now Showing"),
//
//            ModelUpcomingFilm(title = "How to Train Your Dragon: The Hidden World", actors = "Jay Baruchel\n" +
//                    "America Ferrera\n" +
//                    "Cate Blanchett\n" +
//                    "Craig Ferguson\n" +
//                    "Jonah Hill\n" +
//                    "Kit Harington\n" +
//                    "Justin Rupple\n" +
//                    "Kristen Wiig\n" +
//                    "Christopher Mintz-Plasse\n" +
//                    "F. Murray Abraham\n" +
//                    "Gerard Butler",
//                directors = "Dean DeBlois", img_source = "https://upload.wikimedia.org/wikipedia/id/f/fd/How_to_Train_Your_Dragon_3_poster.png",
//                synopsis =  "How to Train Your Dragon: The Hidden World adalah film fantasi laga animasi komputer " +
//                        "3D Amerika Serikat tahun 2019 yang diproduksi oleh DreamWorks Animation dan didistribusikan oleh " +
//                        "Universal Pictures. Film ini dibuat berdasarkan seri buku Inggris dengan nama yang sama oleh Cressida Cowell. " +
//                        "Film ini adalah sekuel film animasi-komputer 2014 How to Train Your Dragon 2 dan yang ketiga dalam trilogi. " +
//                        "Film ini akan menjadi film animasi DreamWorks Animation yang pertama didistribusikan oleh Universal Pictures.",
//                        status = "Now Showing"),
//
//            ModelUpcomingFilm(title = "The Nun", actors = "Bonnie Aarons\n" +
//                    "Demián Bichir\n" +
//                    "Taissa Farmiga\n" +
//                    "Jonas Bloquet",
//                directors = "Corin Hardy", img_source = "https://upload.wikimedia.org/wikipedia/id/3/34/TheNunPoster.jpg",
//                synopsis =  "Rumania tahun 1952, 2 biarawati yang hidup di Cârța Monastery diserang sebuah kekuatan tak terlihat ketika mereka memasuki sebuah terowongan untuk mengambil kembali sebuah pusaka peninggalan kekristenan. Biarawati yang selamat, Suster Victoria lari dari setan yang berwujud biarawati, dan menggantung dirinya sendiri. Tubuhnya ditemukan oleh Frenchie, seorang warga desa yang mengangkut persediaan untuk para biarawati.\n" +
//                        "\n" +
//                        "Vatikan mempelajari peristiwa tersebut dan memanggil Pastor Burke ke Roma, " +
//                        "di mana mereka memintanya untuk melakukan perjalanan ke Rumania bersama suster Irene, " +
//                        "salah seorang suster di novisiat untuk menginvestigasi situasinya. Ketika suster Irene sedang " +
//                        "mengajar anak - anak mengenai hubungan antara agama dan ilmu pengetahun di sekolah, biarawati " +
//                        "seniornya menyelanya dan mengatakan bahwa Pastor Burke telah tiba untuk memintanya menemani perjalanannya" +
//                        " ke Rumania.", status = "Now Showing"),
//
//            ModelUpcomingFilm(title = "Avengers: Endgame", actors = "Robert Downey Jr.\n" +
//                    "Chris Evans\n" +
//                    "Mark Ruffalo\n" +
//                    "Chris Hemsworth\n" +
//                    "Scarlett Johansson\n" +
//                    "Jeremy Renner\n" +
//                    "Don Cheadle\n" +
//                    "Paul Rudd\n" +
//                    "Brie Larson\n" +
//                    "Karen Gillan\n" +
//                    "Danai Gurira\n" +
//                    "Benedict Wong\n" +
//                    "Jon Favreau\n" +
//                    "Bradley Cooper\n" +
//                    "Gwyneth Paltrow\n" +
//                    "Josh Brolin",
//                directors = "Anthony Russo, Joe Russo", img_source = "https://upload.wikimedia.org/wikipedia/id/7/7e/Avengers_-_Endgame.jpg",
//                synopsis =  "Setengah dari semua kehidupan di alam semesta hancur ketika Thanos menggunakan Batu Infinity, " +
//                        "termasuk keluarga Clint Barton. Dua puluh tiga hari kemudian, Carol Danvers menyelamatkan Nebula dan " +
//                        "Tony Stark, yang terdampar di luar angkasa setelah pertarungan mereka dengan Thanos. Mereka bergabung " +
//                        "dengan Natasha Romanoff, Bruce Banner, Steve Rogers, Rocket, Thor, Pepper Potts, dan James Rhodes di " +
//                        "Bumi. Kelompok itu menemukan Thanos disebuah planet terpencil dan berencana untuk merebut dan " +
//                        "menggunakan batu Infinity dan membalikkan tindakannya, tetapi Thanos telah menghancurkan batu " +
//                        "tersebut untuk mencegah digunakan kembali. Thor yang marah akhirnya memenggal Thanos.",
//                        status = "Now Showing"),
//
//            ModelUpcomingFilm(title = "Single", actors = "Raditya Dika\n" +
//                    "Pandji Pragiwaksono\n" +
//                    "Chandra Liow\n" +
//                    "Annisa Rawles\n" +
//                    "Babe Cabita\n" +
//                    "Difa Ryansyah\n" +
//                    "Brigitta Cynthia",
//                directors = "Raditya Dika", img_source = "https://m.media-amazon.com/images/M/MV5BMTg5MjA0MTIyNV5BMl5BanBnXkFtZTgwNDMxOTEyNzE@._V1_.jpg",
//                synopsis =  "bercerita tentang sosok Ebi (Raditya Dika), seorang pemuda 27 tahun yang naif dan " +
//                        "belum mempunyai pekerjaan. Ebi bahkan masih sering meminta uang dari ibunya setiap kali " +
//                        "ibunya datang ke Jakarta. Ebi juga seorang single forever atau jomblo dari lahir yang belum " +
//                        "pernah pacaran. Hal ini terjadi karena setiap kali Ebi mendekati perempuan, Ebi selalu saja ditolak. " +
//                        "Intinya, kehidupan Ebi layak untuk dikasihani.\n" +
//                        "\n" +
//                        "Suatu hari, adik Ebi, Alva (Frederik Alexander) yang lebih ganteng dan " +
//                        "sukses darinya mengumumkan kalau dia hendak menikah. Karena inilah, Ebi pun mencari " +
//                        "pacar untuk dibawa ke kawinan Alva. Agar harga dirinya di depan ibunya masih bisa diselamatkan. " +
//                        "Dibantu oleh kedua orang teman kosannya, Wawan (Pandji Pragiwaksono) yang paling sok tahu dan Victor (" +
//                        "Babe Cabita) yang pesimistis, Ebi pun mulai mencari cewek satu per satu yang juga berujung pada " +
//                        "kegagalan.", status = "Now Showing"),
//
//            ModelUpcomingFilm(title = "Spider-Man: Homecoming 2", actors = "",
//                directors = "Jon Watts", img_source = "https://m.media-amazon.com/images/M/MV5BNmIxMzY4ZTgtYmMzOS00NTU5LWJjYzAtYjM5YmE3OTAwMTFlXkEyXkFqcGdeQXVyNTAzNzgwNTg@._V1_UX182_CR0,0,182,268_AL_.jpg",
//                synopsis =  "Peter Parker (Tom Holland) tengah mengunjungi Eropa " +
//                        "untuk liburan panjang bersama temaan-temanya. Sayangnya , Parker tidak bisa dengan " +
//                        "tenang menikmati liburannya, karena Nick Fury datang secara tiba-tiba di kamar hotelnya. " +
//                        "Selama di Eropa pun Peter harus menghadapi banyak musuh mulai dari Hydro Man, " +
//                        "Sandman dan Molten Man.", status = "Upcoming")
//        )
//
//        val filmAdapter = UpcomingFilmAdapter(listFilm){
////            Toast.makeText(applicationContext, "${it.title} Clicked", Toast.LENGTH_LONG).show()
//            val intent = Intent(this, DetailActivity::class.java)
//            intent.putExtra("item", it)
//
//            startActivity(intent)
//        }
//
//        rv_up_film.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = filmAdapter
//        }
    }
}
