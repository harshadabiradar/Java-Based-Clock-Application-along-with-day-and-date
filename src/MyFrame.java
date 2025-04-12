import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame{


    Calendar calendar;
    SimpleDateFormat timeformat;
    SimpleDateFormat dayformat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;


    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MY Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);//cant cange the application size


        //        //oracle website timeformat,dayformat and date........
        //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text

        timeformat = new SimpleDateFormat("hh:mm:ss a");

        //dayformat = new SimpleDateFormat("E");//E gives day of the week in 3 characters such as sun,mon.......
        dayformat = new SimpleDateFormat("EEEE");//gives full week day

        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));

        dateLabel  = new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.PLAIN,30));

        time = timeformat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        this.setVisible(true);

        setTime();

    }
    public void setTime(){
        while (true){
            time = timeformat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayformat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }



}
