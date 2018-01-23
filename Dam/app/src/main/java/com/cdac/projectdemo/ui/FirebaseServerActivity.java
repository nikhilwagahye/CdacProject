package com.cdac.projectdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.model.BookList;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FirebaseServerActivity extends AppCompatActivity {

    private FirebaseApp auth;
    private FirebaseApp firebaseInstance;

    private Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_server);
        btnBook=(Button)findViewById(R.id.button_firebase);


        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                DatabaseReference database = FirebaseDatabase.getInstance().getReference();
                /*
                1. create list of images for each book
                2. use that while creating a list of books, in books constructor
                3. With this, add book information as shown below constructor
                4. iterate on that list of books in switch case as shown
                5. do same for how many category you want.
                    */
//bussiness & economics book images

                List<String> Blist1 = new ArrayList<String>();
                //alibaba book=bussiness & economics
                Blist1.add("https://images-na.ssl-images-amazon.com/images/I/41%2Bc-nA7hYL.jpg");
                Blist1.add("https://images-na.ssl-images-amazon.com/images/I/51-ylvPKrLL.jpg");
                Blist1.add("https://images-na.ssl-images-amazon.com/images/I/31Is5KHZwkL.jpg");


                List<String> Blist2 = new ArrayList<String>();
                //Business Adventures book=bussiness & economics
                Blist2.add("https://images-na.ssl-images-amazon.com/images/I/81qGXFU-0mL.jpg");
                Blist2.add("https://images-na.ssl-images-amazon.com/images/I/51TifELU4eL.jpg");

                List<String> Blist3 = new ArrayList<String>();
                //Fiasco book=bussiness & economics
                Blist3.add("https://images-na.ssl-images-amazon.com/images/I/81-HmC08KOL.jpg");
                Blist3.add("https://images-na.ssl-images-amazon.com/images/I/51gZF%2BeG0iL.jpg");
                Blist3.add("https://images-na.ssl-images-amazon.com/images/I/41WQo4IwsHL.jpg");

                List<String> Blist4 = new ArrayList<String>();
                //Hooked book=bussiness & economics
                Blist4.add("https://images-na.ssl-images-amazon.com/images/I/811Ngi2hYIL.jpg");
                Blist4.add("https://images-na.ssl-images-amazon.com/images/I/71lm95aFkxL.jpg");
                Blist4.add("https://images-na.ssl-images-amazon.com/images/I/31CKZS8Y3qL.jpg");

                List<String> Blist5 = new ArrayList<String>();
                //The Hard Thing About Things book=bussiness & economics
                Blist5.add("https://images-na.ssl-images-amazon.com/images/I/51slqM2g3jL.jpg");
                Blist5.add("https://images-na.ssl-images-amazon.com/images/I/91RDS3iBW5L.jpg");
                Blist5.add("https://images-na.ssl-images-amazon.com/images/I/31vxzIZad0L.jpg");

                List<String> Blist6 = new ArrayList<String>();
                //Zero To One book=bussiness & economics
                Blist6.add("https://images-na.ssl-images-amazon.com/images/I/412hq8iLwKL.jpg");
                Blist6.add("https://images-na.ssl-images-amazon.com/images/I/81PSEZzjQfL.jpg");
                Blist6.add("https://images-na.ssl-images-amazon.com/images/I/71P-glANdAL.jpg");
                Blist6.add("https://images-na.ssl-images-amazon.com/images/I/31uZs-qfWJL.jpg");

 //travel book images

                List<String> Tlist1 = new ArrayList<String>();
                //A Walk in the Woods=travel
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/51FH8CFR32L.jpg");
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/61QCw9KWk1L.jpg");
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/41FOHG6m0KL.jpg");

                List<String> Tlist2 = new ArrayList<String>();
                //Born to Run=travel
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/81l271UiWaL.jpg");
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/719AwnOnStL.jpg");

                List<String> Tlist3 = new ArrayList<String>();
                //Into Thin Air=travel
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/511pyvWg3YL.jpg");
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/51x3rg99niL.jpg");
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/31%2BN-R4wZCL.jpg");

                List<String> Tlist4 = new ArrayList<String>();
                //The MotorCycle Diaries=travel
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/71hMNh-BWdL.jpg");

                List<String> Tlist5 = new ArrayList<String>();
                //Zen & The Art Of Motorcycle Maintenance=travel
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/81njOhS%2B1nL.jpg");
                Tlist1.add("https://images-na.ssl-images-amazon.com/images/I/51yLAHlkqjL.jpg");

//editors corners images
                List<String> Elist1 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner

                Elist1.add("https://images-na.ssl-images-amazon.com/images/I/61XpsFs2ggL.jpg");
                Elist1.add("https://images-na.ssl-images-amazon.com/images/I/71teVrQiayL.jpg");


                List<String> Elist2 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Elist2.add("https://images-na.ssl-images-amazon.com/images/I/51Mn6IUJI%2BL.jpg");
                Elist2.add("https://images-na.ssl-images-amazon.com/images/I/41gNirHl5KL.jpg");
                Elist2.add("https://images-na.ssl-images-amazon.com/images/I/41Bits-alML.jpg ");

                List<String> Elist3 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Elist3.add("https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg");
                Elist3.add("https://images-na.ssl-images-amazon.com/images/I/91R1lC3DVNL.jpg");
                Elist3.add("https://images-na.ssl-images-amazon.com/images/I/41YUa-2EQdL.jpg");

                List<String> Elist4 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Elist4.add("https://images-na.ssl-images-amazon.com/images/I/71ZNdhVPAEL.jpg");
                Elist4.add("https://images-na.ssl-images-amazon.com/images/I/819CNMucZ1L.jpg");

                List<String> Elist5 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Elist5.add("https://images-na.ssl-images-amazon.com/images/I/51rv6edfY6L.jpg");
                Elist5.add("https://images-na.ssl-images-amazon.com/images/I/41cXWaZTPQL.jpg");
                Elist5.add("https://images-na.ssl-images-amazon.com/images/I/41Ya5UnPezL.jpg");

                List<String> Elist6 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Elist6.add("https://images-na.ssl-images-amazon.com/images/I/410PdJzYsML.jpg");
                Elist6.add("https://images-na.ssl-images-amazon.com/images/I/51GrvgvXL5L.jpg");
                Elist6.add("https://images-na.ssl-images-amazon.com/images/I/41l9nojqgvL.jpg");
//fiction images=======================================================

                List<String> Flist1 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Flist1.add("https://images-na.ssl-images-amazon.com/images/I/71NorptAMCL._AC_SX75_CR,0,0,75,75_.jpg");
                Flist1.add("https://images-na.ssl-images-amazon.com/images/I/51Kekkh9NvL.jpg");
                Flist1.add("https://images-na.ssl-images-amazon.com/images/I/81jzC3iaofL.jpg");
                Flist1.add("https://images-na.ssl-images-amazon.com/images/I/81ReWzIplZL.jpg");

                List<String> Flist2 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Flist2.add("https://images-na.ssl-images-amazon.com/images/I/51SW8VHeQjL.jpg");
                Flist2.add("https://images-na.ssl-images-amazon.com/images/I/51KYkwfLnEL.jpg");
                Flist2.add("https://images-na.ssl-images-amazon.com/images/I/91pZCOn2UtL.jpg");

                List<String> Flist3 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Flist3.add("https://images-na.ssl-images-amazon.com/images/I/51kA-Upq61L._SX325_BO1,204,203,200_.jpg");
                Flist3.add("https://images-na.ssl-images-amazon.com/images/I/51fSzl3ZBDL.jpg");

                List<String> Flist4 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Flist4.add("https://images-na.ssl-images-amazon.com/images/I/81l6zbSjSzL._AC_SX75_CR,0,0,75,75_.jpg");
                Flist4.add("https://images-na.ssl-images-amazon.com/images/I/91pfECWv2vL.jpg");
                Flist4.add("https://images-na.ssl-images-amazon.com/images/I/312kFh5JVpL.jpg");

                List<String> Flist5 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Flist5.add("https://images-na.ssl-images-amazon.com/images/I/51DzoDo6%2BLL.jpg");
                Flist5.add("https://images-na.ssl-images-amazon.com/images/I/51-W8ghLwEL.jpg");
                Flist5.add("https://images-na.ssl-images-amazon.com/images/I/41-IxmMiKUL.jpg");

                List<String> Flist6 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Flist6.add("https://images-na.ssl-images-amazon.com/images/I/51nziLHeduL.jpg");
                Flist6.add("https://images-na.ssl-images-amazon.com/images/I/A1OAyoncyVL.jpg");
                Flist6.add("https://images-na.ssl-images-amazon.com/images/I/41RWQHkPCKL._AC_SX60_CR,0,0,60,60_.jpg");


//Children's & Young Adult images======================================
                List<String> Clist1 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/91R1lC3DVNL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/41YUa-2EQdL.jpg");

                List<String> Clist2 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/91R1lC3DVNL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/41YUa-2EQdL.jpg");

                List<String> Clist3 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Clist3.add("https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg");
                Clist3.add("https://images-na.ssl-images-amazon.com/images/I/91R1lC3DVNL.jpg");
                Clist3.add("https://images-na.ssl-images-amazon.com/images/I/41YUa-2EQdL.jpg");

                List<String> Clist4 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Clist4.add("https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg");
                Clist4.add("https://images-na.ssl-images-amazon.com/images/I/91R1lC3DVNL.jpg");
                Clist4.add("https://images-na.ssl-images-amazon.com/images/I/41YUa-2EQdL.jpg");

                List<String> Clist5 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/91R1lC3DVNL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/41YUa-2EQdL.jpg");

                List<String> Clist6 = new ArrayList<String>();
                //Diary Of a Wimpy Kids=editors corner
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/91R1lC3DVNL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/41YUa-2EQdL.jpg");

//used books==========================================================
                List<String> Ulist1 = new ArrayList<String>();
                //Bhagavad-Gita=used books
                Ulist1.add("https://images-na.ssl-images-amazon.com/images/I/515I-ymlpnL.jpg");
                Ulist1.add("https://images-na.ssl-images-amazon.com/images/I/51mYuc-2OrL.jpg");

                List<String> Ulist2 = new ArrayList<String>();
                //Bhagavad-Gita=used books
                Ulist2.add("https://images-na.ssl-images-amazon.com/images/I/91zSjxzaz2L.jpg");
                Ulist2.add("https://images-na.ssl-images-amazon.com/images/I/91N%2BRCZGMjL.jpg");
                Ulist2.add("https://images-na.ssl-images-amazon.com/images/I/31z94%2BnV9yL.jpg");

                List<String> Ulist3 = new ArrayList<String>();
                //Bhagavad-Gita=used books
                Ulist3.add("https://images-na.ssl-images-amazon.com/images/I/41eQREm0YjL.jpg");
                Ulist3.add("https://images-na.ssl-images-amazon.com/images/I/71%2B85Bzn%2BNL.jpg");
                Ulist3.add("https://images-na.ssl-images-amazon.com/images/I/31lOHko4h3L.jpg");

                List<String> Ulist4 = new ArrayList<String>();
                //Bhagavad-Gita=used books
                Ulist4.add("https://images-na.ssl-images-amazon.com/images/I/51rMuXi7WQL.jpg");
                Ulist4.add("https://images-na.ssl-images-amazon.com/images/I/51JfFRovHuL.jpg");

                List<String> Ulist5 = new ArrayList<String>();
                //Bhagavad-Gita=used books
                Ulist5.add("https://images-na.ssl-images-amazon.com/images/I/91I7KpY20gL.jpg");
                Ulist5.add("https://images-na.ssl-images-amazon.com/images/I/91pmbK42PHL.jpg");
                Ulist5.add("https://images-na.ssl-images-amazon.com/images/I/31zUY7IpOiL.jpg");

                List<String> Ulist6 = new ArrayList<String>();
                //Bhagavad-Gita=used books
                Ulist6.add("https://images-na.ssl-images-amazon.com/images/I/91sJmZFOIQL.jpg");
                Ulist6.add("https://images-na.ssl-images-amazon.com/images/I/91NAkeIbCvL.jpg");
                Ulist6.add("https://images-na.ssl-images-amazon.com/images/I/41cpI3uFNZL.jpg");




                String cat1 = "booklist/Business and Economics";
                String cat2 = "booklist/Travel";
                String cat3 = "booklist/Editor Corner";
                String cat4 = "booklist/Fiction";
                String cat5 = "booklist/Children and Young Adult";
                String cat6 = "booklist/Used Books";


//bussiness & eco books list==================================================

                List<BookList> listForCat1 = new ArrayList<BookList>();
                //     String id, String name, String author, String description,String publisher,int pages, List<String> imageUrl, int quantity, double price {

                listForCat1.add(new BookList("1", "Alibaba", "Duncan Clark"," An engrossing, insider’s account of how a teacher built one of the world’s most valuable companies—rivaling Walmart and Amazon—and forever reshaped the global economy", "Ecco; Latest Edition edition (18 April 2016)"
                        , 304, Blist1, 5, 382));

                listForCat1.add(new BookList("2", "Business Adventures", "John Brooks", "Stories about Wall Street are infused with drama and adventure and reveal the machinations and volatile nature of the world of finance.",
                        "Hodder And Stoughton; new edition (12 November 2014)", 180, Blist2, 6, 220));

                listForCat1.add(new BookList("3", "Fiasco", "Frank Partnoy", "FIASCO is the shocking story of one man's education in the jungles of Wall Street. As a young derivatives salesman at Morgan  Stanley, Frank Partnoy learned to buy and sell billions of dollars worth of securities that were so complex many traders themselves didn't understand them.",
                        "Penguin USA (1 February 1999)", 288, Blist3, 5, 499));

                listForCat1.add(new BookList("4", "Hooked", "Nir Eyal", "The book, 'Hooked: How to Build Habit-Forming Products’ is an effective book for people who want to learn the art of selling products. This book derives strategies from stories of products that have made it big in their respective industries whilst citing the reasons for their success.",
                        "Portfolio Penguin; Latest Edition edition (6 November 2014)", 256, Blist4, 6, 499));

                listForCat1.add(new BookList("5", "The Hard Thing About Things", "Ben Horowitz", "Ben Horowitz, cofounder of Andreessen Horowitz and one of Silicon Valley's most respected and experienced entrepreneurs, offers essential advice on building and running a startup—practical wisdom for managing the toughest problems business school doesn’t cover, based on his popular ben’s blog.",
                        "Harper Business; Revised Edition edition (8 June 2014)", 304, Blist5, 5, 414));

                listForCat1.add(new BookList("6", "Zero To One", "Peter Thiel and Blake Masters", "The next Bill Gates will not build an operating system. The next Larry Page or Sergey Brin won’t make a search engine. If you are copying these guys, you aren’t learning from them. It’s easier to copy a model than to make something new: doing what we already know how to do takes the world from 1 to n, adding more of something familiar. Every new creation goes from 0 to 1. This book is about how to get there.",
                        "Random House; 2014 edition (18 September 2014)", 320, Blist6, 6, 155));

//travel book list=============================================================================

                List<BookList> listForCat2 = new ArrayList<BookList>();
                //     public Book(String id, String name, String author, String description, List<String> imageUrl, int quantity, double price) {

                listForCat2.add(new BookList("1", "A Walk in the Woods", "Bill Bryson", "A Walk in the Woods is more than just a laugh-out-loud hike. Bryson's acute eye is a wise witness to this beautiful but fragile trail, and as he tells its fascinating history, he makes a moving plea for the conservation of America's last great wilderness. An adventure, a comedy, and a celebration, 'A Walk in the Woods' has becomea modern classic of travel literature.",
                        "Perfection Learning (4 May 1999)", 284, Tlist1, 5, 410));

                listForCat2.add(new BookList("2", "Born To Run", "Christopher McDougall", "The Hidden Tribe, The Ultra-Runners and The Greatest Race The World Has Never Seen is centrally focused on a mysterious tribe of Mexican Indians called the Tarahumara. These nomadic folk lived quietly in canyons and are reputed to be the best distance runners in the world.",
                        "Profile Books Ltd; Main edition (15 April 2010)", 304, Tlist2, 6, 275));

                listForCat2.add(new BookList("3", "Into Thin Air", "Jon Krakauer", "One of the inspirations for the major motion picture Everest, starring Jake Gyllenhaal and Keira Knightley. Jon Krakauer's Into Thin Air is the true story of a 24-hour period on Everest, when members of three separate expeditions were caught in a storm and faced a battle against hurricane-force winds, exposure, and the effects of altitude, which ended the worst single-season death toll in the peak's history.",
                        "Pan; new edition (1 July 2011)", 352, Tlist3, 5, 235));

                listForCat2.add(new BookList("4", "The Motorcycle Diaries", "Ernesto 'Che' Guevara", " The Motorcycle Diaries is a story which revolves around 2 men who embark on a road journey on a 1939 Norton 500cc cylinder motorcycle from Buenos Aires. They are out to discover and explore South America. This book had been written 8 years prior to the Cuban Revolution.",
                        "Harper Perennial; Film tie-in edition edition (5 September 2007)", 200, Tlist4, 6, 1700));

                listForCat2.add(new BookList("5", "Zen & The Art Of Motorcycle Maintenance ", "Robert Pirsig", "Acclaimed as one of the most exciting books in the history of American letters, this modern epic became an instant bestseller upon publication in 1974, transforming a generation and continuing to inspire millions.",
                        "Vintage; The 40th Anniversary edition edition (11 September 2014)", 432, Tlist5, 2, 257));

//editors corner===============================================================================

                List<BookList> listForCat3 = new ArrayList<BookList>();
                //     public Book(String id, String name, String author, String description, List<String> imageUrl, int quantity, double price) {

                listForCat3.add(new BookList("1", "Diary Of a Wimpy Kid", "Jeff Kinney", "Diary of a Wimpy Kid: Rodrick Rules is a sequel to the colossal hit 'Diary of a Wimpy Kid’. The story rotates around an 8th grader Gregory Heffley who is facing some problems which usually is not faced by a mid-school child.",
                        "Penguin UK; Reprint edition (5 February 2009)",224, Elist1, 5, 148));
                listForCat3.add(new BookList("2", "I Am Malala", "Malala Yousafzai", "Written by one defiant young women who stood up to the mounting atrocities of terrorist Taliban, this book describes the journey of a simple Pakistani girl from Swat Valley who stood up for a basic right to education that nearly cost her, her life.",
                        "Orion Publishing Group; Latest edition (9 October 2014)",320, Elist2, 6, 174));
                listForCat3.add(new BookList("3", "Looking For Alaska", "John Green", "This is an amazing first novel by a writer who is young enough to vividly remember his powerful years of high school and he expertly turns remembrance into story.",
                        "Harpercollins; Latest edition (1 February 2013)",271, Elist3, 5, 171));
                listForCat3.add(new BookList("4", "Steve Jobs", "Walter Isaacson", "An extraordinary book which gives us a unique insight into the life and thinking of the man who has single-handedly transformed the way we live today",
                        "Little, Brown Book Group; 2015 edition (11 February 2015)",592, Elist4, 6, 274));
                listForCat3.add(new BookList("5", "The Fault in our Stars", "John Green", "The Fault in Our Stars is distinct love story of two teenage cancer sufferers and revolves around a couple who fall for each other irrespective of the fact that they are struggling between life and death. This book blends in it all kinds of elements such as humor, sentiment and emotions.",
                        "Penguin; Movie Tie-in Edition edition (28 May 2014)",336, Elist5, 4, 199));
                listForCat3.add(new BookList("6", "Women And The Weight Loss Tamasha", "Rujuta Diwekar", "Women and The Weight Loss Tamasha is based on the health and nutrition fundamentals and principles. This book by renowned nutritionist, Rujuta Diwekar, helps women in losing weight, toning their bodies, bringing the glow on their faces and some sort of wisdom in their brains. The women have to concentrate on their weight issues right from their puberty, marriage, pregnancy to menopause. The body weight fluctuates with these hormonal changes in their bodies.",
                        "Westland; 1 edition (27 December 2010)",374, Elist6, 5, 184));
//fiction books list=============================================================

                List<BookList> listForCat4 = new ArrayList<BookList>();
                //     public Book(String id, String name, String author, String description, List<String> imageUrl, int quantity, double price) {

                listForCat4.add(new BookList("1", "Every One Has A Story", "Savi Sharma", "Everyone has a story. Meera, a fledgling writer who is in search of a story that can touch millions of lives. Vivaan, assistant branch manager at Citibank, who dreams of travelling the world. ,Kabir, a café manager who desires something of his own. Nisha, the despondent café customer who keeps secrets of her own.",
                        "Westland; Latest edition (9 August 2016))",184, Elist1, 5, 75));
                listForCat4.add(new BookList("2", "Harry Porter And The Cursed Child", "J.K. Rowling", "This book is written in script format, which is different from a novel format. The Eighth Tale in the Harry Potter Saga",
                        "Little Brown; new edition (1 August 2016)",352, Elist2, 7, 405));
                listForCat4.add(new BookList("3", "One Indian Girl", "Chetan Bhagat", "One Indian Girl is about an Indian girl who is intelligent and successful, because of which she finds it difficult to get love.",
                        "Rupa Publications India; First edition (1 October 2016)",280, Elist3, 6, 71));
                listForCat4.add(new BookList("4", "The Alchemist", "Paulo Coelho", "Paulo Coelho's enchanting novel has inspired a devoted following around the world. This story, dazzling in its powerful simplicity and inspiring wisdom, is about an Andalusian shepherd boy named Santiago who travels from his homeland in Spain to the Egyptian desert in search of a treasure buried in the Pyramids.",
                        "Harper; Later Printing edition (17 October 2005)",172, Elist4, 8, 174));

                listForCat4.add(new BookList("5", "The Mahabharat Secret", "Christopher C. Doyle", "It is a thriller novel that revolves around mythology, science, religion and terrorism. The story-line takes the readers all the way back to ancient times in 244 B.C., where Emperor Ashoka the Great discovers a dark secret of the great Mahabharata. The secret is so dangerous that it could cause massive destruction to mankind if falls into wrong hands.",
                        "Om Books International; First edition (21 October 2013)",386, Elist5, 5, 169));

                listForCat4.add(new BookList("6", "The Three Mistakes Of My Life", "Chetan Bhagat", "The 3 Mistakes of my life is the third novel written by eminent Indian Author Chetan Bhagat. Based on cricket, business and religion, the novel is set against the backdrop of beautiful city Ahmedabad. Revolving around three young Indian boys Omi, Ishaan and Govind, the book goes on to narrate how the three are trying their best to make ends meet in the city.",
                        "Rupa Publications India; 2nd edition edition (1 January 2014)",260, Elist6, 6, 100));
//Children's & Young Adult==================================================
                List<BookList> listForCat5 = new ArrayList<BookList>();
                //     public Book(String id, String name, String author, String description, List<String> imageUrl, int quantity, double price) {

                listForCat5.add(new BookList("1", "Diary Of a Wimpy Kid", "Jeff Kinney", "Diary of a Wimpy Kid: Rodrick Rules is a sequel to the colossal hit 'Diary of a Wimpy Kid’. The story rotates around an 8th grader Gregory Heffley who is facing some problems which usually is not faced by a mid-school child.",
                        "Penguin UK; Reprint edition (5 February 2009)",224, Elist1, 5, 148));
                listForCat5.add(new BookList("2", "I Am Malala", "Malala Yousafzai", "Written by one defiant young women who stood up to the mounting atrocities of terrorist Taliban, this book describes the journey of a simple Pakistani girl from Swat Valley who stood up for a basic right to education that nearly cost her, her life.",
                        "Orion Publishing Group; Latest edition (9 October 2014)",320, Elist2, 6, 174));
                listForCat5.add(new BookList("3", "Looking For Alaska", "John Green", "This is an amazing first novel by a writer who is young enough to vividly remember his powerful years of high school and he expertly turns remembrance into story.",
                        "Harpercollins; Latest edition (1 February 2013)",271, Elist3, 5, 171));
                listForCat5.add(new BookList("4", "Steve Jobs", "Walter Isaacson", "An extraordinary book which gives us a unique insight into the life and thinking of the man who has single-handedly transformed the way we live today",
                        "Little, Brown Book Group; 2015 edition (11 February 2015)",592, Elist4, 6, 274));
                listForCat5.add(new BookList("5", "The Fault in our Stars", "John Green", "The Fault in Our Stars is distinct love story of two teenage cancer sufferers and revolves around a couple who fall for each other irrespective of the fact that they are struggling between life and death. This book blends in it all kinds of elements such as humor, sentiment and emotions.",
                        "Penguin; Movie Tie-in Edition edition (28 May 2014)",336, Elist5, 4, 199));
                listForCat5.add(new BookList("6", "Women And The Weight Loss Tamasha", "Rujuta Diwekar", "Women and The Weight Loss Tamasha is based on the health and nutrition fundamentals and principles. This book by renowned nutritionist, Rujuta Diwekar, helps women in losing weight, toning their bodies, bringing the glow on their faces and some sort of wisdom in their brains. The women have to concentrate on their weight issues right from their puberty, marriage, pregnancy to menopause. The body weight fluctuates with these hormonal changes in their bodies.",
                        "Westland; 1 edition (27 December 2010)",374, Elist6, 5, 184));
//used books==================================================================
              List<BookList> listForCat6 = new ArrayList<BookList>();
                //     public Book(String id, String name, String author, String description, List<String> imageUrl, int quantity, double price) {

                listForCat6.add(new BookList("1", "Bhagavad-Gita", "A. C. Bhaktivedanta & Swami Prabhupada", "One of the most profound book that sums up the essence of all that Hindu philosophy stands for, the Bhagavad Gita, from the original Sanskrit version has been translated into several languages of the world.",
                        "BBT; First edition (2012)",459, Ulist1, 6, 141));
                listForCat6.add(new BookList("2", "History Of Modern India", "Bipan Chandra", "History of Modern India is one of the famous books of Bipin Chandra. This book was published by Orient Blackswan in 2009. This book is a journey mapping the path of colonial India in from the eighteenth century to the twentieth century. It traces the timeline of British rule which majorly coincides with the modern Indian history.",
                        "Orient BlackSwan; First edition (2009)",360, Ulist2, 7, 240));
                listForCat6.add(new BookList("3", "Life Is What You Make It", "Preeti Shenoy", "Life Is What You Make It, was published on January 1, 2011 and it turned out to be a national bestseller. The book has also featured in the “Top Books of 2011, ” a Nielsen list, which is released by the Hindustan Times.",
                        "Srishti Publishers; 1 edition (1 January 2011)",224, Ulist3, 5, 75));
                listForCat6.add(new BookList("4", "Sita", "Amish Tripathi", "Immerse yourself in book 2 of the Ram Chandra series, based on the Ramayana, the story of Lady Sita, written by the multi-million bestselling Indian Author Amish; the author who has transformed Indian Fiction with his unique combination of mystery, mythology, religious symbolism and philosophy.",
                        "Westland (29 May 2017)",376, Ulist4, 6, 172));
                listForCat6.add(new BookList("5", "The Monk Who Sold His Ferrari", "Robin Sharma", "The Monk Who Sold His Ferrari is a revealing story that offers the readers a simple yet profound way to live life. The plot of this story revolves around Julian Mantle, a lawyer who has made his fortune and name in the profession.",
                        "Jaico Publishing House; First edition (25 September 2003)",198, Ulist5, 6, 130));
                listForCat6.add(new BookList("6", "Word Power Made Easy", "Norman Lewis", "A core book about English language and correct word usage; those who are preparing to sit for CAT, GMAT, GRE, TOEFL and other such examinations would definitely stand to greatly benefit from this book.",
                        "Goyal; Reprint edition (1 June 2011)",686, Ulist6, 2, 94));


                for (int i = 0; i < 6; i++) {

                    switch (i) {

                        case 0:
                            // Category 1
                            for (int catType1 = 0; catType1 < listForCat1.size(); catType1++) {
                                BookList book = listForCat1.get(catType1);
                                database.child(cat1).child(book.getId()).setValue(book);
//                       database.child(cat1).child(listForCat1.get(catType1).getId()).setValue(listForCat1.get(catType1));
                            }
                            break;
                        case 1:
                            // Category 2

                            for (int catType2 = 0; catType2 < listForCat2.size(); catType2++) {
                                database.child(cat2).child(listForCat2.get(catType2).getId()).setValue(listForCat2.get(catType2));
                            }
                            break;
                        case 2:
                            // Category 3

                            for (int catType3 = 0; catType3 < listForCat3.size(); catType3++) {
                                database.child(cat3).child(listForCat3.get(catType3).getId()).setValue(listForCat3.get(catType3));
                            }
                            break;
                        case 3:
                            // Category 4

                            for (int catType4 = 0; catType4 < listForCat4.size(); catType4++) {
                                database.child(cat4).child(listForCat4.get(catType4).getId()).setValue(listForCat4.get(catType4));
                            }
                            break;
                        case 4:
                            // Category 5

                            for (int catType5 = 0; catType5 < listForCat5.size(); catType5++) {
                                database.child(cat5).child(listForCat5.get(catType5).getId()).setValue(listForCat5.get(catType5));
                            }
                            break;
                        case 5:
                            // Category 6

                            for (int catType6 = 0; catType6 < listForCat6.size(); catType6++) {
                                database.child(cat6).child(listForCat6.get(catType6).getId()).setValue(listForCat6.get(catType6));
                            }
                            break;

                    }

                }
            }

        });

    }
}
