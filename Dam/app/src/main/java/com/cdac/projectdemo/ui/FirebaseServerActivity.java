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
                Tlist2.add("https://images-na.ssl-images-amazon.com/images/I/81l271UiWaL.jpg");
                Tlist2.add("https://images-na.ssl-images-amazon.com/images/I/719AwnOnStL.jpg");

                List<String> Tlist3 = new ArrayList<String>();
                //Into Thin Air=travel
                Tlist3.add("https://images-na.ssl-images-amazon.com/images/I/511pyvWg3YL.jpg");
                Tlist3.add("https://images-na.ssl-images-amazon.com/images/I/51x3rg99niL.jpg");
                Tlist3.add("https://images-na.ssl-images-amazon.com/images/I/31%2BN-R4wZCL.jpg");

                List<String> Tlist4 = new ArrayList<String>();
                //The MotorCycle Diaries=travel
                Tlist4.add("https://images-na.ssl-images-amazon.com/images/I/71hMNh-BWdL.jpg");

                List<String> Tlist5 = new ArrayList<String>();
                //Zen & The Art Of Motorcycle Maintenance=travel
                Tlist5.add("https://images-na.ssl-images-amazon.com/images/I/81njOhS%2B1nL.jpg");
                Tlist5.add("https://images-na.ssl-images-amazon.com/images/I/51yLAHlkqjL.jpg");

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
                //Death Cure
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/81NP5IsU%2BzL.jpg");
                Clist1.add("https://images-na.ssl-images-amazon.com/images/I/81jfVCAUjBL.jpg");

                List<String> Clist2 = new ArrayList<String>();
                //I am Yoga
                Clist2.add("https://images-na.ssl-images-amazon.com/images/I/51jPTytrhaL._AC_SX75_CR,0,0,75,75_.jpg");
                Clist2.add("https://images-na.ssl-images-amazon.com/images/I/51hPtMtKKCL.jpg");
                Clist2.add("https://images-na.ssl-images-amazon.com/images/I/61v62UNC2EL.jpg");
                Clist2.add("https://images-na.ssl-images-amazon.com/images/I/61DiMwtRamL.jpg");
                Clist2.add("https://images-na.ssl-images-amazon.com/images/I/71Brjrxe%2BhL.jpg");
                Clist2.add("https://images-na.ssl-images-amazon.com/images/I/61smmscAdDL.jpg");

                List<String> Clist3 = new ArrayList<String>();
                //The Dragon Prophecy
                Clist3.add("https://images-na.ssl-images-amazon.com/images/I/51AiwNSZnrL.jpg");
                Clist3.add("https://images-na.ssl-images-amazon.com/images/I/51FzzF%2BWQsL.jpg");
                Clist3.add("https://images-na.ssl-images-amazon.com/images/I/41KKYqTBCvL.jpg");


                List<String> Clist4 = new ArrayList<String>();
                //The Haunted Castle
                Clist4.add("https://images-na.ssl-images-amazon.com/images/I/81X-kmNhgdL.jpg");
                Clist4.add("https://images-na.ssl-images-amazon.com/images/I/81H-jclFYiL.jpg");
                Clist4.add("https://images-na.ssl-images-amazon.com/images/I/41Bgtxln4qL.jpg");

                List<String> Clist5 = new ArrayList<String>();
                //The Magical Mission
                Clist5.add("https://images-na.ssl-images-amazon.com/images/I/81beMakPviL.jpg");
                Clist5.add("https://images-na.ssl-images-amazon.com/images/I/81qJAS4uogL.jpg");

                List<String> Clist6 = new ArrayList<String>();
                //The story Of Adam and Eve
                Clist6.add("https://images-na.ssl-images-amazon.com/images/I/91XtTLSej1L.jpg");
                Clist6.add("https://images-na.ssl-images-amazon.com/images/I/A16IYjx3%2BAL.jpg");



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

                //Indian History Books.................................................................

                List<String> Ilist1 = new ArrayList<String>();
                //An Era Of Darkness-Indian History
                Ilist1.add("https://images-na.ssl-images-amazon.com/images/I/91Tu6fhpR6L.jpg");


                List<String> Ilist2 = new ArrayList<String>();
                //Aurangzeb-Indian History
                Ilist2.add("https://images-na.ssl-images-amazon.com/images/I/91Vi-BU5UGL.jpg");


                List<String> Ilist3 = new ArrayList<String>();
                //Indian Summer-Indian HIstory
                Ilist3.add("https://images-na.ssl-images-amazon.com/images/I/51U4ZF5okvL.jpg");
                Ilist3.add("https://images-na.ssl-images-amazon.com/images/I/81V7Myu3ddL.jpg");

                List<String> Ilist4 = new ArrayList<String>();
                //Indira-Indian History
                Ilist4.add("https://images-na.ssl-images-amazon.com/images/I/81KP%2BYS9FZL.jpg");
                Ilist4.add("https://images-na.ssl-images-amazon.com/images/I/71lm95aFkxL.jpg");

                List<String> Ilist5 = new ArrayList<String>();
                //The Argumentative Indian-Indian History
                Ilist5.add("https://images-na.ssl-images-amazon.com/images/I/61luELyY5fL.jpg");
                Ilist5.add("https://images-na.ssl-images-amazon.com/images/I/81pFv6SwgzL.jpg");

                List<String> Ilist6 = new ArrayList<String>();
                //The Discovery Of India-Indian History
                Ilist6.add("https://images-na.ssl-images-amazon.com/images/I/61qCo8cKMnL.jpg");


                //Society And Social Sciences Books.................................................................

                List<String> Slist1 = new ArrayList<String>();
                //A Feast Of Vultures-Society
                Slist1.add("https://images-na.ssl-images-amazon.com/images/I/81wdKi56yyL.jpg");
                Ilist1.add("https://images-na.ssl-images-amazon.com/images/I/81E8ZzW4fsL.jpg");


                List<String> Slist2 = new ArrayList<String>();
                //GirlBoss-Society
                Slist2.add("https://images-na.ssl-images-amazon.com/images/I/81-R9UAlC3L.jpg");
                Slist2.add("https://images-na.ssl-images-amazon.com/images/I/71Yg%2BPyLGKL.jpg");

                List<String> Slist3 = new ArrayList<String>();
                //Option B-Society
                Slist3.add("https://images-na.ssl-images-amazon.com/images/I/71a-uOxqK7L.jpg");
                Slist3.add("https://images-na.ssl-images-amazon.com/images/I/718Lo156StL.jpg");

                List<String> Slist4 = new ArrayList<String>();
                //Predictably Irrational-Society
                Slist4.add("https://images-na.ssl-images-amazon.com/images/I/81brJ%2BJh0zL.jpg");
                Slist4.add("https://images-na.ssl-images-amazon.com/images/I/81MieNss8sL.jpg");
                Slist4.add("https://images-na.ssl-images-amazon.com/images/I/41uWM%2BB-WLL.jpg");

                List<String> Slist5 = new ArrayList<String>();
                //Quiet-Society
                Slist5.add("https://images-na.ssl-images-amazon.com/images/I/71xEUuZsUoL.jpg");
                Slist5.add("https://images-na.ssl-images-amazon.com/images/I/61G-WdxmyZL.jpg");
                Slist5.add("https://images-na.ssl-images-amazon.com/images/I/31Em7R0DO1L.jpg");

                List<String> Slist6 = new ArrayList<String>();
                //Sapiens-Society
                Slist6.add("https://images-na.ssl-images-amazon.com/images/I/41MJX6yzfeL.jpg");
                Slist6.add("https://images-na.ssl-images-amazon.com/images/I/514PjiO3ViL.jpg");
                Slist6.add("https://images-na.ssl-images-amazon.com/images/I/317PsVMj6nL.jpg");

                List<String> Slist7 = new ArrayList<String>();
                //The Immortals Of Meluha-Society
                Slist7.add("https://images-na.ssl-images-amazon.com/images/I/515mxVegEUL.jpg");
                Slist7.add("https://images-na.ssl-images-amazon.com/images/I/51FSSnfg%2BEL.jpg");
                Slist7.add("https://images-na.ssl-images-amazon.com/images/I/41ammhSEZ4L.jpg");

                List<String> Slist8= new ArrayList<String>();
                //Untouchable-Society
                Slist8.add("https://images-na.ssl-images-amazon.com/images/I/51Ba1MbtTkL.jpg");




                String cat1 = "booklist/Business and Economics";
                String cat2 = "booklist/Travel Books";
                String cat3 = "booklist/Editor Corner";
                String cat4 = "booklist/Fiction";
                String cat5 = "booklist/Children and Young Adult";
                String cat6 = "booklist/Used Books";
                String cat7 = "booklist/Indian History";
                String cat8 = "booklist/Society And Social Science";



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
                        "Harper Perennial; Film tie-in edition edition (5 September 2007)", 200, Tlist4, 6, 174));

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
                        "Westland; Latest edition (9 August 2016))",184, Flist1, 5, 75));
                listForCat4.add(new BookList("2", "Harry Porter And The Cursed Child", "J.K. Rowling", "This book is written in script format, which is different from a novel format. The Eighth Tale in the Harry Potter Saga",
                        "Little Brown; new edition (1 August 2016)",352, Flist2, 7, 405));
                listForCat4.add(new BookList("3", "One Indian Girl", "Chetan Bhagat", "One Indian Girl is about an Indian girl who is intelligent and successful, because of which she finds it difficult to get love.",
                        "Rupa Publications India; First edition (1 October 2016)",280, Flist3, 6, 71));
                listForCat4.add(new BookList("4", "The Alchemist", "Paulo Coelho", "Paulo Coelho's enchanting novel has inspired a devoted following around the world. This story, dazzling in its powerful simplicity and inspiring wisdom, is about an Andalusian shepherd boy named Santiago who travels from his homeland in Spain to the Egyptian desert in search of a treasure buried in the Pyramids.",
                        "Harper; Later Printing edition (17 October 2005)",172, Flist4, 8, 174));

                listForCat4.add(new BookList("5", "The Mahabharat Secret", "Christopher C. Doyle", "It is a thriller novel that revolves around mythology, science, religion and terrorism. The story-line takes the readers all the way back to ancient times in 244 B.C., where Emperor Ashoka the Great discovers a dark secret of the great Mahabharata. The secret is so dangerous that it could cause massive destruction to mankind if falls into wrong hands.",
                        "Om Books International; First edition (21 October 2013)",386, Flist5, 5, 169));

                listForCat4.add(new BookList("6", "The Three Mistakes Of My Life", "Chetan Bhagat", "The 3 Mistakes of my life is the third novel written by eminent Indian Author Chetan Bhagat. Based on cricket, business and religion, the novel is set against the backdrop of beautiful city Ahmedabad. Revolving around three young Indian boys Omi, Ishaan and Govind, the book goes on to narrate how the three are trying their best to make ends meet in the city.",
                        "Rupa Publications India; 2nd edition edition (1 January 2014)",260, Flist6, 6, 100));
//Children's & Young Adult==================================================
                List<BookList> listForCat5= new ArrayList<BookList>();
                //     public Book(String id, String name, String author, String description, List<String> imageUrl, int quantity, double price) {

                listForCat5.add(new BookList("1","Death Cure","James Dashner ","The Death Cure is a 2011 young adult dystopian science fiction novel written by American writer James Dashner and the third book, fifth chronologically, in the Maze Runner series.","Scholastic; 1 edition (2 October 2013)",384,Clist1,6,219));

                listForCat5.add(new BookList("2","I Am Yoga","Susan Verde & Peter H. Reynolds","An eagle soaring among the clouds or a star twinkling in the night sky ...a camel in the desert or a boat sailing across the sea--yoga has the power of transformation. Not only does it strengthen bodies and calm minds, but with a little imagination, it can show us that anything is possible.","Harry N. Abrams (8 September 2015)",32,Clist2,9,732));

                listForCat5.add(new BookList("3","The Dragon Prophecy","Geronimo Stilton","The Dragon Prophecy is an autobiographical adventure which rotates around Geronimoâ€™s life. Geronimo is a slight artificial talking mouse who works as a journalist and an editor for a functional newspaper","Scholastic Incorporated; Special edition (1 September 2012)",320,Clist3,7,344));

                listForCat5.add(new BookList("4","The Haunted Castle","Geronimo Stilton","A Childrenâ€™s Bookshelf Selection: Each month our editorâ€™s pick the best books for children and young adults by age to be a part of the childrenâ€™s bookshelf. These are editorial recommendations made by our team of experts.","Scholastic Incorporated; Reissue edition (1 July 2011)",110,Clist4,6,182));

                listForCat5.add(new BookList("5","The Magical Mission","Geronimo Stilton","I was traveling to London, England on a secret mission! I had to investigate some strange occurrences --someone was trying to get their paws on the crown jewels! Trap came along, too, to compete in a big magic show. And before I could solve my mystery, Trap needed my help. To perform an impossible magic trick. Could I do it all? Squeak!","Scholastic (25 October 2016)",128,Clist5,8,164));

                listForCat5.add(new BookList("6","The Story of Adam and Eve"," Pegasus Team","The Bible Story narrates the story of Joshua, who took over as the leader of Hebrews after Mosses and lead them to acquire the kingdom of Jericho. All the Bible stories have one common message that is to believe in god and everything else would be solved. In this book, the same message has been conveyed. The coloured pictures and easy text makes the story more interesting."," Pegasus; First edition (1 March 2012)",16,Clist6,7,57));

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


//Indian History Book List.................................................................

                List<BookList> listForCat7 = new ArrayList<>();

                listForCat7.add(new BookList("1","An Era Of Darkness","Shashi Tharoor","In An Era of Darkness, consummate debater and author Shashi Tharoor recreates the British Raj with all its horrors and also elucidates the awe-inspiring struggle of India's freedom fighters. He gives us a valuable insight on how dark forces operate and on who are harbingers of hopeâ€”it's a valuable lesson at a time when thugs are masquerading as our savioursâ€¦at a time when debate has been reduced to a cacophony of slogans and insults by bhakts.","Aleph Book Company; Latest edition (27 October 2016)",360,Ilist1,8,450));

                listForCat7.add(new BookList("2","Aurangzeb","Audrey Truschke","Aurangzeb Alamgir (r. 1658â€“1707), the sixth Mughal emperor, is widely reviled in India today. Hindu hater, murderer and religious zealot are just a handful of the modern caricatures of this maligned ruler. While many continue to accept the storyline peddled by colonial-era thinkersâ€”that Aurangzeb, a Muslim, was a Hindu-loathing bigotâ€”there is an untold side to him as a man who strove to be a just, worthy Indian king.","Penguin Random House India (10 February 2017)",216,Ilist2,6,229));

                listForCat7.add(new BookList("3","Indian Summer","Alex Von Tunzelmann","INDIAN SUMMER depicts the epic sweep of events that ripped apart the greatest empire the world has ever seen, and reveals the secrets of the most powerful players on the world stage: the Cold War conspiracies, the private deals, and the intense and clandestine love affair between the wife of the last viceroy and the first prime minister of free India. With wit, insight and a sharp eye for detail, Alex von Tunzelmann relates how a handful of people changed the world for ever.","Simon & Schuster; UK ed. edition (29 March 2008)",480,Ilist3,5,399));

                listForCat7.add(new BookList("4","Indira","Katherine Frank ","This biography, the first to be written by an unpartisan, Western woman, will focus on Gandhiâ€™s role as a female leader of men in one of the most chauvinistic, complex and politicised cultures in the world.Comprehensive, yet also personal, Frankâ€™s biography will deal with power and how this often isolated woman handled it, alongside her family and her emotional life. It will be the definitive book on one of this centuryâ€™s most powerful and important women.","Harper Perennial (5 March 2007)",592,Ilist4,9,374));

                listForCat7.add(new BookList("5","The Argumentative Indian","Amartya Sen","The Argumentative Indian: Writings on Indian History, Culture and Identity has been written by none other than Nobel Laureate Amartya Sen. The book comprises of sixteen interlinked essays that explain in detail the rich background on which India has built its foundations on. In four sections the book tries to delineate the importance of perceiving contemporary India easily.","Penguin UK; 1St Edition edition (29 August 2006)",256,Ilist5,7,206));

                listForCat7.add(new BookList("6","The Discovery Of India","Jawaharlal Nehru","Jawaharlal Nehru wrote the book â€˜The Discovery of Indiaâ€™, during his imprisonment at Ahmednagar fort for participating in the Quit India Movement (1942 â€“ 1946). The book was written during Nehruâ€™s four years of confinement to solitude in prison and is his way of paying an homage to his beloved country and its rich culture.","Penguin India; New edition (1 February 2008)",656,Ilist6,8,370));


                //Society And Social Sciences Book List................................................

                List<BookList> listForCat8 = new ArrayList<>();

                listForCat8.add(new BookList("1","A Feast Of Vultures","Josy Joseph","'Every day, millions of people - the rich, the poor and the many foreign visitors - are hunting for ways to get their business done in modern India. If they search in the right places and offer the appropriate price, there is always a facilitator who can get the job done. This book is a sneak preview of those searches, the middlemen who do those jobs, and the many opportunities that the fast-growing economy offers.' Josy Joseph draws upon two decades as an investigative journalist to expose a problem so pervasive that we do not have the words to speak of it.","HarperCollins India; 1 edition (28 July 2016)",256,Slist1,6,405));

                listForCat8.add(new BookList("2","Girlboss","Sophia Amoruso","GIRLBOSS is more than a book and Sophia Amoruso is more than a purveyor of (fine and fly) garments. #GIRLBOSS is a movement - a philosophy for making your work life as fun, fresh and raunchy as your personal adventures. Sophia encourages us to own the qualities we've previously been ashamed of (bossiness, crudeness, petty thievery) in order to become the masters of our own destiny, financially independent and radically ourselves.","Portfolio (6 August 2015)",256,Slist2,7,409));

                listForCat8.add(new BookList("3","Option B","Sheryl Sandberg","OPTION B offers compelling insights for dealing with hardships in our own lives and helping others in crisis. It turns out that post-traumatic growth is commonâ€”even after the most devastating experiences many people donâ€™t just bounce back but actually bounce forward. And pre-traumatic growth is also possible: people can build resilience even if they have not experienced tragedy. Sandberg and Grant explore how we can raise strong children, create resilient communities and workplaces and find meaning, love and joy in our lives.","Random House (24 April 2017)",256,Slist3,6,350));

                listForCat8.add(new BookList("4","Predictably Irrational"," Dan Ariely","'Predictably Irrational: The Hidden Forces that Shape Our Decisionsâ€™ is a book on human behavior which tries to understand why we humans tend to make certain decisions and behave in certain ways. This book takes into account human reactions across a wide range of situations and tries to decipher the reasons. The main aspect of this book is to find out the process behind decision making. The intriguing language of this book along with the powerful narration makes this book a must have.","Harpercollins (18 February 2010",304,Slist4,9,252));

                listForCat8.add(new BookList("5","Quiet","Susan Cain","'Quiet: The power of introverts in a world that can't stop talking' by Susa Cain is a Kick-starter of the quiet revolution and talks about all successful introverts. In todayâ€™s world where everyone has a lot to say, silence is quintessential and that is exactly what this book wants to convey. The power of silence is always underestimated but the writer has given some very useful and substantial insights about why it is so important. It also talks about some highly inspirational motivators in the world who were introverts like Dale Carnegie and Tony Robbins.","Penguin UK; Latest edition (3 February 2013)",352,Slist5,5,265));

                listForCat8.add(new BookList("6","Sapiens","Yuval Noah Harari ","FIRE gave us power, FARMING made us hungry for more, MONEY gave us purpose,SCIENCE made us deadly.This is the thrilling account of our extraordinary history â€“ from insignificant apes to rulers of the world.","Penguin Random House; Paperback edition (11 June 2015)",512,Slist6,6,273));

                listForCat8.add(new BookList("7","The Immortals Of Meluha","Amish ","An intense story 'The Immortals of Meluha' draws heavily from stories and legends of Hindu mythology that have been passed on from generation to generation."," Westland; Revised Edition edition (24 July 2017)",415,Slist7,9,152));

                listForCat8.add(new BookList("8","Untouchable","Mulk Raj Anand","Untouchable is a novel by Mulk Raj Anand published in 1935. The novel established Anand as one of India's leading English authors.The book was inspired by his aunt's experience when she had a meal with a Muslim woman and was treated as an outcast by his family.The plot of this book, Anand's first, revolves around the argument for eradicating the caste system.It depicts a day in the life of Bakha, a young \"sweeper\", who is \"untouchable\" due to his work cleaning latrines.","Penguin India; New edition edition (29 August 2001)",160,Slist8,8,156));


                for (int i = 0; i < 8; i++) {

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
                        case 6:
                            //Category 7

                            for (int catType7 = 0; catType7 < listForCat7.size(); catType7++) {
                                BookList book = listForCat7.get(catType7);
                                database.child(cat7).child(book.getId()).setValue(book);
                            }
                            break;
                        case 7:
                            //Category 8

                            for (int catType8 = 0; catType8 < listForCat8.size(); catType8++) {
                                BookList book = listForCat8.get(catType8);
                                database.child(cat8).child(book.getId()).setValue(book);
                            }
                            break;



                    }

                }
            }

        });

    }
}
