package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main {
	int _pot = 0;

	private JFrame frmThreeCardPoker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmThreeCardPoker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frmThreeCardPoker = new JFrame();
		frmThreeCardPoker.getContentPane().setBackground(new Color(0, 100, 0));
		frmThreeCardPoker.setTitle("Three Card Poker");
		frmThreeCardPoker.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/logo.png")));
		frmThreeCardPoker.setBounds(100, 100, 936, 638);
		frmThreeCardPoker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThreeCardPoker.getContentPane().setLayout(null);
		frmThreeCardPoker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton chip5 = new JButton("");
		chip5.setBackground(new Color(0, 100, 0));
		chip5.setIcon(new ImageIcon(Main.class.getResource("/img/5$.png")));
		chip5.setBorderPainted(false);
		chip5.setBounds(12, 10, 100, 100);
		frmThreeCardPoker.getContentPane().add(chip5);

		JButton chip25 = new JButton("");
		chip25.setBackground(new Color(0, 100, 0));
		chip25.setIcon(new ImageIcon(Main.class.getResource("/img/25$.png")));
		chip25.setBorderPainted(false);
		chip25.setBounds(12, 120, 100, 100);
		frmThreeCardPoker.getContentPane().add(chip25);

		JButton chip100 = new JButton("");
		chip100.setBackground(new Color(0, 100, 0));
		chip100.setIcon(new ImageIcon(Main.class.getResource("/img/100$.png")));
		chip100.setBorderPainted(false);
		chip100.setBounds(12, 230, 100, 100);
		frmThreeCardPoker.getContentPane().add(chip100);

		JButton chip500 = new JButton("");
		chip500.setBackground(new Color(0, 100, 0));
		chip500.setIcon(new ImageIcon(Main.class.getResource("/img/500$.png")));
		chip500.setBorderPainted(false);
		chip500.setBounds(12, 340, 100, 100);
		frmThreeCardPoker.getContentPane().add(chip500);

		JLabel backSide2 = new JLabel("");
		backSide2.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
		backSide2.setBounds(549, 96, 130, 198);
		frmThreeCardPoker.getContentPane().add(backSide2);

		JLabel backSide1 = new JLabel("");
		backSide1.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
		backSide1.setBounds(419, 96, 130, 198);
		frmThreeCardPoker.getContentPane().add(backSide1);

		JLabel backSide = new JLabel("");
		backSide.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
		backSide.setBounds(289, 96, 130, 198);
		frmThreeCardPoker.getContentPane().add(backSide);

		JLabel QS = new JLabel("");
		QS.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/QS.png")));
		QS.setBounds(549, 386, 130, 198);
		frmThreeCardPoker.getContentPane().add(QS);

		JLabel KS = new JLabel("");
		KS.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/KS.png")));
		KS.setBounds(419, 386, 130, 198);
		frmThreeCardPoker.getContentPane().add(KS);

		JLabel AS = new JLabel("");
		AS.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/AS.png")));
		AS.setBounds(289, 386, 130, 198);
		frmThreeCardPoker.getContentPane().add(AS);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(808, 561, 97, 23);
		frmThreeCardPoker.getContentPane().add(btnQuit);

		JButton btnResetBet = new JButton("Reset Bet");
		btnResetBet.setFont(new Font("Arial", Font.PLAIN, 12));
		btnResetBet.setBounds(12, 516, 105, 23);
		frmThreeCardPoker.getContentPane().add(btnResetBet);

		JButton btnReplayBet = new JButton("Replay Bet");
		btnReplayBet.setFont(new Font("Arial", Font.PLAIN, 12));
		btnReplayBet.setBounds(12, 483, 105, 23);
		frmThreeCardPoker.getContentPane().add(btnReplayBet);

		JPanel panelPot = new JPanel();
		panelPot.setBackground(new Color(0, 255, 0));
		panelPot.setBounds(12, 450, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPot);

		JLabel pot = new JLabel("0");
		pot.setFont(new Font("Arial", Font.PLAIN, 12));
		pot.setHorizontalAlignment(SwingConstants.CENTER);
		panelPot.add(pot);

		JPanel panelPlayer1 = new JPanel();
		panelPlayer1.setBackground(new Color(0, 255, 0));
		panelPlayer1.setBounds(419, 63, 130, 23);
		frmThreeCardPoker.getContentPane().add(panelPlayer1);

		JLabel lblNewLabel = new JLabel("Dealer");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPlayer1.add(lblNewLabel);

		JPanel panelPlayer0 = new JPanel();
		panelPlayer0.setBackground(Color.GREEN);
		panelPlayer0.setBounds(419, 353, 130, 23);
		frmThreeCardPoker.getContentPane().add(panelPlayer0);

		JLabel lblYou = new JLabel("You");
		lblYou.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPlayer0.add(lblYou);

		JPanel panelAnte = new JPanel();
		panelAnte.setBackground(new Color(0, 255, 0));
		panelAnte.setBounds(124, 120, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelAnte);

		JLabel lblNewLabel_2 = new JLabel("Ante Pot");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panelAnte.add(lblNewLabel_2);

		JPanel panelAnteNum = new JPanel();
		panelAnteNum.setBounds(124, 153, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelAnteNum);

		JLabel lblNewLabel_3 = new JLabel("0");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		panelAnteNum.add(lblNewLabel_3);

		JPanel panelPairPlus = new JPanel();
		panelPairPlus.setBackground(new Color(0, 255, 0));
		panelPairPlus.setBounds(124, 186, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPairPlus);

		JLabel lblNewLabel_4 = new JLabel("Pair+ Pot");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPairPlus.add(lblNewLabel_4);

		JPanel panelPairPlusNum = new JPanel();
		panelPairPlusNum.setBounds(124, 219, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPairPlusNum);

		JLabel lblNewLabel_5 = new JLabel("0");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPairPlusNum.add(lblNewLabel_5);

		JPanel panelPlay = new JPanel();
		panelPlay.setBackground(new Color(0, 255, 0));
		panelPlay.setBounds(124, 252, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPlay);

		JLabel lblNewLabel_6 = new JLabel("Play Pot");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPlay.add(lblNewLabel_6);

		JPanel panelPlayNum = new JPanel();
		panelPlayNum.setBounds(124, 285, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPlayNum);

		JLabel lblNewLabel_7 = new JLabel("0");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPlayNum.add(lblNewLabel_7);

		JButton btnCommit = new JButton("Commit");
		btnCommit.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCommit.setBounds(12, 549, 105, 23);
		frmThreeCardPoker.getContentPane().add(btnCommit);

		JPanel panelBank = new JPanel();
		panelBank.setBackground(Color.GREEN);
		panelBank.setBounds(800, 10, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelBank);

		JLabel lblBank = new JLabel("Bank");
		lblBank.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBank.add(lblBank);

		JPanel panelBankBoard = new JPanel();
		panelBankBoard.setBounds(800, 43, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelBankBoard);

		JLabel lblBankBoard = new JLabel("0");
		lblBankBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBankBoard.add(lblBankBoard);
		
		JButton btnFold = new JButton("Fold");
		btnFold.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFold.setBounds(755, 96, 105, 23);
		frmThreeCardPoker.getContentPane().add(btnFold);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlay.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPlay.setBounds(755, 129, 105, 23);
		frmThreeCardPoker.getContentPane().add(btnPlay);
		
		JPanel panelHelper = new JPanel();
		panelHelper.setBounds(354, 298, 265, 32);
		frmThreeCardPoker.getContentPane().add(panelHelper);
		
		JLabel lblHelper = new JLabel("Helper");
		panelHelper.add(lblHelper);
		
		JPanel panelDealerHandBoard = new JPanel();
		panelDealerHandBoard.setBounds(755, 239, 113, 23);
		frmThreeCardPoker.getContentPane().add(panelDealerHandBoard);
		
		JLabel lblDealerHandBoard = new JLabel("Straight Flush");
		lblDealerHandBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDealerHandBoard.add(lblDealerHandBoard);
		
		JPanel panelDealerHand = new JPanel();
		panelDealerHand.setBackground(Color.GREEN);
		panelDealerHand.setBounds(755, 206, 113, 23);
		frmThreeCardPoker.getContentPane().add(panelDealerHand);
		
		JLabel lblDealerHand = new JLabel("Dealer");
		lblDealerHand.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDealerHand.add(lblDealerHand);
		
		JPanel panelGamerHandBoard = new JPanel();
		panelGamerHandBoard.setBounds(755, 307, 113, 23);
		frmThreeCardPoker.getContentPane().add(panelGamerHandBoard);
		
		JLabel lblGamerHandBoard = new JLabel("High");
		lblGamerHandBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelGamerHandBoard.add(lblGamerHandBoard);
		
		JPanel panelGamerHand = new JPanel();
		panelGamerHand.setBackground(Color.GREEN);
		panelGamerHand.setBounds(755, 274, 113, 23);
		frmThreeCardPoker.getContentPane().add(panelGamerHand);
		
		JLabel lblGamerHand = new JLabel("Gamer");
		lblGamerHand.setFont(new Font("Arial", Font.PLAIN, 12));
		panelGamerHand.add(lblGamerHand);
		
		JPanel panelWins = new JPanel();
		panelWins.setBackground(new Color(255, 255, 255));
		panelWins.setBounds(727, 439, 130, 23);
		frmThreeCardPoker.getContentPane().add(panelWins);
		
		JLabel lblWins = new JLabel("Wins");
		lblWins.setFont(new Font("Arial", Font.PLAIN, 12));
		panelWins.add(lblWins);
		
		JPanel panelWinsBoard = new JPanel();
		panelWinsBoard.setBackground(new Color(255, 255, 255));
		panelWinsBoard.setBounds(860, 439, 45, 23);
		frmThreeCardPoker.getContentPane().add(panelWinsBoard);
		
		JLabel lblWinsBoard = new JLabel("0");
		lblWinsBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelWinsBoard.add(lblWinsBoard);
		
		JPanel panelLoses = new JPanel();
		panelLoses.setBackground(new Color(255, 255, 255));
		panelLoses.setBounds(727, 470, 130, 23);
		frmThreeCardPoker.getContentPane().add(panelLoses);
		
		JLabel lblLoses = new JLabel("Loses");
		lblLoses.setFont(new Font("Arial", Font.PLAIN, 12));
		panelLoses.add(lblLoses);
		
		JPanel panelLosesBoard = new JPanel();
		panelLosesBoard.setBackground(new Color(255, 255, 255));
		panelLosesBoard.setBounds(860, 470, 45, 23);
		frmThreeCardPoker.getContentPane().add(panelLosesBoard);
		
		JLabel lblLosesBoard = new JLabel("0");
		lblLosesBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelLosesBoard.add(lblLosesBoard);
		
		JPanel panelWinningRate = new JPanel();
		panelWinningRate.setBackground(new Color(255, 255, 255));
		panelWinningRate.setBounds(727, 503, 130, 23);
		frmThreeCardPoker.getContentPane().add(panelWinningRate);
		
		JLabel lblWinningRate = new JLabel("Winning %");
		lblWinningRate.setFont(new Font("Arial", Font.PLAIN, 12));
		panelWinningRate.add(lblWinningRate);
		
		JPanel panelWinningRateBoard = new JPanel();
		panelWinningRateBoard.setBackground(new Color(255, 255, 255));
		panelWinningRateBoard.setBounds(860, 503, 45, 23);
		frmThreeCardPoker.getContentPane().add(panelWinningRateBoard);
		
		JLabel lblWinningRateBoard = new JLabel("0");
		lblWinningRateBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelWinningRateBoard.add(lblWinningRateBoard);
		
		JPanel panelStatistics = new JPanel();
		panelStatistics.setBackground(Color.WHITE);
		panelStatistics.setBounds(755, 406, 130, 23);
		frmThreeCardPoker.getContentPane().add(panelStatistics);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setFont(new Font("Arial", Font.PLAIN, 12));
		panelStatistics.add(lblStatistics);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/img/logo.png")));
		lblNewLabel_1.setBounds(338, 173, 300, 300);
		frmThreeCardPoker.getContentPane().add(lblNewLabel_1);

		// btnActionListener
		ArrayList<Integer> forReplay = new ArrayList<>();
		forReplay.add(0, 0);

		chip5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_pot += 5;
				forReplay.add(_pot);
				pot.setText(Integer.toString(_pot));
			}
		});
		chip25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_pot += 25;
				forReplay.add(_pot);
				pot.setText(Integer.toString(_pot));
			}
		});
		chip100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_pot += 100;
				forReplay.add(_pot);
				pot.setText(Integer.toString(_pot));
			}
		});
		chip500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_pot += 500;
				forReplay.add(_pot);
				pot.setText(Integer.toString(_pot));
			}
		});
		btnResetBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forReplay.add(_pot);
				_pot = 0;
				pot.setText(Integer.toString(_pot));
			}
		});
		btnReplayBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(forReplay.size() > 1) {
					_pot = forReplay.get(forReplay.size() - 2);
					forReplay.remove(forReplay.size() - 1);
					pot.setText(Integer.toString(_pot));
				}
				else {
					_pot = 0;
					pot.setText(Integer.toString(_pot));
				}
			}
		});
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThreeCardPoker.dispose();
			}
		});

		frmThreeCardPoker.setResizable(false);
	}
}
