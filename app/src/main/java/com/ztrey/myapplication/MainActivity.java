package com.ztrey.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    //declare main variables
    ArrayList<Quote> quotes;
    int currentQuoteIndex;
    Button nextQuoteButton;
    Button timePickerButton;
    Quote currentQuote;

    //declare view member variables
    TextView quoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign View member variables
        quoteTextView = findViewById(R.id.tv_main_quote);
        nextQuoteButton = findViewById(R.id.bv_main_next_quote);
        timePickerButton = findViewById(R.id.bv_main_time_picker);

        //Create quote list
        instantiateQuotes();

        //Button listener for Next Quote
        nextQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuote = chooseNextQuote();
                showQuote(currentQuote);
            }
        });

        //Button listener for time picker
        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        //Start up the App
        currentQuote = findQuoteOfTheDay();
        showQuote(currentQuote);
    }

    void instantiateQuotes(){
        quotes = new ArrayList<>();

        //Instantiate individual quotes (pasted from excel formula)
        Quote quote0 = new Quote("Do not throw away what you have been given.");
        Quote quote1 = new Quote("Karate begins and ends with respect.");
        Quote quote2 = new Quote("There is no first strike in karate.");
        Quote quote3 = new Quote("Karate stands on the side of justice.");
        Quote quote4 = new Quote("First know yourself, then know others.");
        Quote quote5 = new Quote("Mentality over technique.");
        Quote quote6 = new Quote("The heart must be set free.");
        Quote quote7 = new Quote("Calamity springs from carelessness.");
        Quote quote8 = new Quote("Karate goes beyond the dojo.");
        Quote quote9 = new Quote("Karate is a lifelong pursuit.");
        Quote quote10 = new Quote("Apply the way of karate to all things. Therein lies its beauty.");
        Quote quote11 = new Quote("Karate is like boiling water. Without heat, it returns to its tepid state.");
        Quote quote12 = new Quote("Do not think of winning. Think rather, of not losing.");
        Quote quote13 = new Quote("Make adjustments according to your opponent.");
        Quote quote14 = new Quote("The outcome of a battle depends on how one handles emptiness and fullness.");
        Quote quote15 = new Quote("Think of hands and feet as swords.");
        Quote quote16 = new Quote("When you step beyond your own gate, you face a million enemies.");
        Quote quote17 = new Quote("Formal stances are for beginners. Later, one stands naturally.");
        Quote quote18 = new Quote("Perform kata exactly. Actual combat is another matter.");
        Quote quote19 = new Quote("Do not forget the strength and weakness of power, the extension and contraction of the body, the slowness and speed of techniques.");
        Quote quote20 = new Quote("Be constantly mindful, diligent, and resourceful in your pursuit of the Way");
        Quote quote21 = new Quote("Deal with evil through strength. But affirm the good in man through trust. In this way we are prepared for evil, but we encourage good.");
        Quote quote22 = new Quote("Seek always peace. Wear no paths for the footsteps of others, unless the soul is endangered. We are all linked by our souls. To endanger one, endangers all.");
        Quote quote23 = new Quote("The purpose of discipline is to live more fully, not less.");
        Quote quote24 = new Quote("Avoid, rather than check. Check, rather than hurt. Hurt, rather than maim. Maim, rather than kill. For all life is precious, nor can any be replaced.");
        Quote quote25 = new Quote("Sometimes a stranger known to us for moments can spark our souls to kinship for eternity. […] Because our soul does not keep time; it merely records growth.");
        Quote quote26 = new Quote("Be like the sun, and what is within you will warm the earth.");
        Quote quote27 = new Quote("The thorn defends the rose. It harms only those who would steal the blossom from the plant.");
        Quote quote28 = new Quote("The fearless do not exist.");
        Quote quote29 = new Quote("Adapt what is useful, reject what is useless, and add what is specifically your own.");
        Quote quote30 = new Quote("Try harder.");
        Quote quote31 = new Quote("Weapons are inauspicious tools. They are shunned by heaven's path. Keep them ready with the intent not to use them. That is heaven's path.");
        Quote quote32 = new Quote("The best defense is to not differentiate offense from defense.");
        Quote quote33 = new Quote("All difficult things in the world arise from a state in which they were easy, and all great things from one in which they were small. Therefore the sage, while he never does what is great, is able to accomplish the greatest things.");
        Quote quote34 = new Quote("When walking in foreign lands, watch your step.");
        Quote quote35 = new Quote("From a single action, one draws an entire universe.");
        Quote quote36 = new Quote("Seek, rather, not to contend.");
        Quote quote37 = new Quote("Those who speak convincingly of peace cannot go armed. Those who speak convincingly of peace must not be weak.");
        Quote quote38 = new Quote("Seek what the masters sought. Do not simply follow in their footsteps.");
        Quote quote39 = new Quote("Do not think dishonestly.");
        Quote quote40 = new Quote("The Way is in training.");
        Quote quote41 = new Quote("Become acquainted with every art.");
        Quote quote42 = new Quote("Know the Ways of all professions.");
        Quote quote43 = new Quote("Distinguish between gains and losses in worldly matters.");
        Quote quote44 = new Quote("Develop an intuitive judgment and understanding for everything.");
        Quote quote45 = new Quote("Perceive those things which cannot be seen.");
        Quote quote46 = new Quote("Pay attention even to trifles.");
        Quote quote47 = new Quote("Do nothing which is of no use.");
        Quote quote48 = new Quote("True budo is practiced not only to destroy an enemy. It must also make him, or his own will, gladly lose his spirit to oppose you.");
        Quote quote49 = new Quote("One must try, everyday, to expand one's limits.");
        Quote quote50 = new Quote("If you have confidence in your own words, aspirations, thoughts, and actions, and do your very best, you will have no need to regret the outcome of what you do. Fear and trembling are lot of the person who, while stinting effort, hopes that everything will come out precisely as he wants.");
        Quote quote51 = new Quote("Behind each triumph are new peaks to be conquered.");
        Quote quote52 = new Quote("Each of us has his cowardice. Each of us is afraid to lose, afraid to die. But hanging back is the way to remain a coward for life. The Way to find courage is to seek it on the field of conflict. And the sure way to victory is willingness to risk one's own life.");
        Quote quote53 = new Quote("The path of martial arts begins and ends with courtesy. So be genuinely polite on every occasion.");
        Quote quote54 = new Quote("Subjecting yourself to vigorous training is more for the sake of forging a resolute spirit that can vanquish the self than it is for developing a strong body.");
        Quote quote55 = new Quote("I have not permitted myself to be ignorant of any martial art that exists. Why? Such ignorance is a disgrace to someone who follows the path of the martial arts.");
        Quote quote56 = new Quote("It is not important to be better than someone else, but to be better than yesterday.");
        Quote quote57 = new Quote("If there is effort, there is always accomplishment.");
        Quote quote58 = new Quote("In an argument, you may silence your opponent by pressing an advantage of strength or of wealth or of education. But you do not really convince him. Though he is no longer saying anything, in his heart he still keeps to his opinion. The only way to make him change that opinion is to speak quietly and reasonably. When he understands that you are not trying to defeat him, but only find the truth, he will listen to you and perhaps accept what you tell him.");
        Quote quote59 = new Quote("Paradoxically, the man who has failed and the one who is at the peak of success are in exactly the same position. Each must decide what he will do next and choose the course that take him to the future.");
        Quote quote60 = new Quote("You must learn patience.");
        Quote quote61 = new Quote("Do not let circumstances control you. You change your circumstances.");
        Quote quote62 = new Quote("Being still and doing nothing are two completely different things.");
        Quote quote63 = new Quote("Learn the Way and find your own Way.");
        Quote quote64 = new Quote("If you are always allowed to stop training whenever you feel discomfort, you will find it too easy to give yourself permission to quit.");
        Quote quote65 = new Quote("After sufficient practice, any man will be able to accomplish remarkable feats of strength. But he may go only so far and no farther. There is a limit to human physical strength that no one can exceed.");
        Quote quote66 = new Quote("It isn’t the mountains ahead to climb that wear you out. It’s the pebble in your shoe.");
        Quote quote67 = new Quote("Only a man who knows what it is like to be defeated can reach down to the bottom of his soul and come up with the extra ounce of power it takes to win when the match is even.");
        Quote quote68 = new Quote("Impossible is just a big word thrown around by small men who find it easier to live in the world they’ve been given than to explore the power they have to change it. Impossible is not a fact. It’s an opinion. Impossible is not a declaration. It’s a dare. Impossible is potential. Impossible is temporary. Impossible is nothing.");
        Quote quote69 = new Quote("Bragging is when a person says something and can’t do it. I do what I say.");
        Quote quote70 = new Quote("Relax, and calm your mind. Forget about yourself, and follow your opponent's movement.");
        Quote quote71 = new Quote("People will grow old. No one is invincible forever in this world.");
        Quote quote72 = new Quote("You should make it a habit of putting your all into every little thing you do.");
        Quote quote73 = new Quote("There is no finish line. When you reach one goal, find a new one.");
        Quote quote74 = new Quote("Martial art is a form of expression. An expression from your inner self to your hands and legs.");
        Quote quote75 = new Quote("It does not matter how slowly you go as long as you do not stop.");
        Quote quote76 = new Quote("Walk a single path, becoming neither cocky with victory nor broken with defeat, without forgetting caution when all is quiet or becoming frightened when danger threatens.");
        Quote quote77 = new Quote("The teaching of one virtuous person can influence many. That which has been learned well by one generation can be passed on to a hundred.");
        Quote quote78 = new Quote("I do not know how to defeat others. All I know is the path to defeat myself. Today one must be better than yesterday, and tomorrow better than today. The pursuit of perfection is a lifelong quest that has no end.");
        Quote quote79 = new Quote("You must learn how to wait properly.");
        Quote quote80 = new Quote("Right presence of mind means that the mind or spirit is present everywhere, because it is nowhere attached to any particular place.");
        Quote quote81 = new Quote("The instructor’s business is not to show the Way itself, but to enable the pupil to get the feel of this Way to the goal by adapting it to his individual peculiarities.");
        Quote quote82 = new Quote("A master has failed more times than a beginner has even tried.");
        Quote quote83 = new Quote("Beware the fury of a patient man.");
        Quote quote84 = new Quote("when presented with any situation, breathe, take your time, focus, and then decide what to do.");
        Quote quote85 = new Quote("The journey has to be based on passion. Put yourself in something you love to do. If you love what you do, you're able to dedicate yourself and overcome obstacles.");
        Quote quote86 = new Quote("If we fight for money, I'll stop hitting when you ask me to. If we fight for honor, I'll stop hitting when I feel like it.");
        Quote quote87 = new Quote("The biggest gift I received as a martial artist is, without question, the capacity to be at peace.");
        Quote quote88 = new Quote("If you do not speak up when it matters, when would it matter that you speak? The opposite of courage is conformity. Even a dead fish can go with the flow.");
        Quote quote89 = new Quote("Everybody has fear. The difference is that cowards do not control fear, and the brave get over it.");
        Quote quote90 = new Quote("A 10,000 mile walk begins with a single step and continues one step at a time.");
        Quote quote91 = new Quote("There is nothing wrong with a life of peace and prosperity. I suggest you think about what it is you want from your life.");
        Quote quote92 = new Quote("Failure is only the opportunity to begin again.");
        Quote quote93 = new Quote("It is important to draw wisdom from many different places.");
        Quote quote94 = new Quote("Hope is something you give yourself. That is the meaning of inner strength.");
        Quote quote95 = new Quote("Life happens wherever you are, whether you make it or not.");
        Quote quote96 = new Quote("Nothing makes me more determined to succeed than someone telling me something is impossible.");
        Quote quote97 = new Quote("The uncomfort zone is very important for us. To feel uncomfortable is important to strengthen your spirit. Like the samurai says, if you feel comfortable you must search for the discomfort. Don't look only for the easy way.");
        Quote quote98 = new Quote("You can have talent and strength, but the most important quality is determination.");
        Quote quote99 = new Quote("Every fight has taught me something.");
        Quote quote100 = new Quote("I am a master who learns, and a student who teaches.");
        Quote quote101 = new Quote("Chatting with a fool is a waste of words.");
        Quote quote102 = new Quote("A good capoeirista is humble, polite, and he knows that all the other capoeiristas are fellow human beings.");

        //Update my ArrayList (also passed from excel formula)
        quotes.add(quote0);
        quotes.add(quote1);
        quotes.add(quote2);
        quotes.add(quote3);
        quotes.add(quote4);
        quotes.add(quote5);
        quotes.add(quote6);
        quotes.add(quote7);
        quotes.add(quote8);
        quotes.add(quote9);
        quotes.add(quote10);
        quotes.add(quote11);
        quotes.add(quote12);
        quotes.add(quote13);
        quotes.add(quote14);
        quotes.add(quote15);
        quotes.add(quote16);
        quotes.add(quote17);
        quotes.add(quote18);
        quotes.add(quote19);
        quotes.add(quote20);
        quotes.add(quote21);
        quotes.add(quote22);
        quotes.add(quote23);
        quotes.add(quote24);
        quotes.add(quote25);
        quotes.add(quote26);
        quotes.add(quote27);
        quotes.add(quote28);
        quotes.add(quote29);
        quotes.add(quote30);
        quotes.add(quote31);
        quotes.add(quote32);
        quotes.add(quote33);
        quotes.add(quote34);
        quotes.add(quote35);
        quotes.add(quote36);
        quotes.add(quote37);
        quotes.add(quote38);
        quotes.add(quote39);
        quotes.add(quote40);
        quotes.add(quote41);
        quotes.add(quote42);
        quotes.add(quote43);
        quotes.add(quote44);
        quotes.add(quote45);
        quotes.add(quote46);
        quotes.add(quote47);
        quotes.add(quote48);
        quotes.add(quote49);
        quotes.add(quote50);
        quotes.add(quote51);
        quotes.add(quote52);
        quotes.add(quote53);
        quotes.add(quote54);
        quotes.add(quote55);
        quotes.add(quote56);
        quotes.add(quote57);
        quotes.add(quote58);
        quotes.add(quote59);
        quotes.add(quote60);
        quotes.add(quote61);
        quotes.add(quote62);
        quotes.add(quote63);
        quotes.add(quote64);
        quotes.add(quote65);
        quotes.add(quote66);
        quotes.add(quote67);
        quotes.add(quote68);
        quotes.add(quote69);
        quotes.add(quote70);
        quotes.add(quote71);
        quotes.add(quote72);
        quotes.add(quote73);
        quotes.add(quote74);
        quotes.add(quote75);
        quotes.add(quote76);
        quotes.add(quote77);
        quotes.add(quote78);
        quotes.add(quote79);
        quotes.add(quote80);
        quotes.add(quote81);
        quotes.add(quote82);
        quotes.add(quote83);
        quotes.add(quote84);
        quotes.add(quote85);
        quotes.add(quote86);
        quotes.add(quote87);
        quotes.add(quote88);
        quotes.add(quote89);
        quotes.add(quote90);
        quotes.add(quote91);
        quotes.add(quote92);
        quotes.add(quote93);
        quotes.add(quote94);
        quotes.add(quote95);
        quotes.add(quote96);
        quotes.add(quote97);
        quotes.add(quote98);
        quotes.add(quote99);
        quotes.add(quote100);
        quotes.add(quote101);
        quotes.add(quote102);

    }
    Quote chooseNextQuote(){
        int newQuoteIndex = generateRandomNumber(quotes.size());
        currentQuoteIndex = newQuoteIndex;
        return quotes.get(currentQuoteIndex);
    }
    void showQuote(Quote quote){
        quoteTextView.setText(quote.quoteText);
    }

    int generateRandomNumber(int max) {
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    Quote findQuoteOfTheDay(){
        //1. get numeric representation of the date
        long nowInMilliSec = System.currentTimeMillis();
        int convFact = (1000*60*60*24); // milli > sec > min > hour > day
        int todayInInt = (int)(nowInMilliSec/convFact); //convert to an integer

        //2. put this through a numeric hash to pseudo-randomize the quotes
        int quoteOfTheDayIndex = generateQuoteOfTheDayIndex(todayInInt);

        //3. Return our quote of the day
        return quotes.get(quoteOfTheDayIndex);
    }

    int generateQuoteOfTheDayIndex(int todayInInt){
        int quoteOfTheDayIndex;

        //naive implementation of a hash to allow basic randomizing functionality
        quoteOfTheDayIndex = (todayInInt % quotes.size()); //get size

        return quoteOfTheDayIndex;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,0);

        // The the time selected is before today's current time, don't immediately trigger a notification (this is needed due to some quirky behavior from the API)
        if (calendar.before(Calendar.getInstance())) {
            calendar.add(Calendar.DATE,1);
        }

        Intent intent = new Intent(this,NotificationReceiver.class);

        PendingIntent pendingIntent;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);
        }else {
            pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        }

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(getApplicationContext(),"Reminder set successfully",Toast.LENGTH_SHORT).show();
    }
}