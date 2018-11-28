package boom.game;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import sound.GameSound;

public class GUI extends JFrame{
	public static final int WIDTHJF = 905;              //kich thuoc ngang
	public static final int HEIGHTJF = 610;             // chieu rong
	private MyContainer mContainer;                     // doi tuong thuooc goi game

	public GUI() {
		setSize(WIDTHJF, HEIGHTJF);                 //set frame
		setLayout(new CardLayout());                //
		setLocationRelativeTo(null);                //
		setResizable(false);                        //
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //
		mContainer = new MyContainer(this);         
		add(mContainer);
		addWindowListener(mwindow);
	}

	private WindowAdapter mwindow = new WindowAdapter(){//trieu hoi cua so windown
		@Override
		public void windowClosing(WindowEvent e) {  //trieu hoi 1 cua so dang trong tien trinh dong
			GameSound.getIstance().stop();      //se mat tieng nhac
			PlayGame.IS_RUNNING = false;
		}
	};
}
