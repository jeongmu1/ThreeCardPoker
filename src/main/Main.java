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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Rule;
import game.card.Card;
import game.card.CardDeck;
import game.players.Dealer;
import game.players.Gamer;

public class Main {
	int _pot = 0;
	int phase = 0;
	int money = 5000;
	int tempMoney;
	int anteBet = 0;
	int pairPlusBet = 0;
	int playBet = 0;
	int wins = 0;
	int loses = 0;
	int games = 0;
	double winningRate = 0;
	int[] gamerResult;
	int[] dealerResult;
	String GHandResult;
	String DHandResult;
	boolean phaseBet = false;
	boolean win;
	CardDeck deck = new CardDeck();
	Dealer dealer = new Dealer();
	Gamer gamer = new Gamer();
	Rule rule = new Rule();
	
	ArrayList<Integer> forReplay = new ArrayList<>();
	
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
		frmThreeCardPoker.setBounds(0, 0, 936, 638);
		frmThreeCardPoker.setLocationRelativeTo(null);
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

		JLabel lblDCard3 = new JLabel("");
		lblDCard3.setVisible(false);
		lblDCard3.setBounds(549, 96, 130, 198);
		frmThreeCardPoker.getContentPane().add(lblDCard3);

		JLabel lblDCard2 = new JLabel("");
		lblDCard2.setVisible(false);
		lblDCard2.setBounds(419, 96, 130, 198);
		frmThreeCardPoker.getContentPane().add(lblDCard2);

		JLabel lblDCard1 = new JLabel("");
		lblDCard1.setVisible(false);
		lblDCard1.setBounds(289, 96, 130, 198);
		frmThreeCardPoker.getContentPane().add(lblDCard1);

		JLabel lblGCard3 = new JLabel("");
		lblGCard3.setVisible(false);
		lblGCard3.setBounds(549, 386, 130, 198);
		frmThreeCardPoker.getContentPane().add(lblGCard3);

		JLabel lblGCard2 = new JLabel("");
		lblGCard2.setVisible(false);
		lblGCard2.setBounds(419, 386, 130, 198);
		frmThreeCardPoker.getContentPane().add(lblGCard2);

		JLabel lblGCard1 = new JLabel("");
		lblGCard1.setVisible(false);
		lblGCard1.setBounds(289, 386, 130, 198);
		frmThreeCardPoker.getContentPane().add(lblGCard1);

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
		panelPot.setBackground(Color.WHITE);
		panelPot.setBounds(12, 450, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPot);

		JLabel lblPot = new JLabel("0");
		lblPot.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPot.setHorizontalAlignment(SwingConstants.CENTER);
		panelPot.add(lblPot);

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

		JPanel panelAnteBoard = new JPanel();
		panelAnteBoard.setBounds(124, 153, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelAnteBoard);

		JLabel lblAnteBoard = new JLabel("0");
		lblAnteBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelAnteBoard.add(lblAnteBoard);

		JPanel panelPairPlus = new JPanel();
		panelPairPlus.setBackground(new Color(0, 255, 0));
		panelPairPlus.setBounds(124, 186, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPairPlus);

		JLabel lblNewLabel_4 = new JLabel("Pair+ Pot");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPairPlus.add(lblNewLabel_4);

		JPanel panelPairPlusBoard = new JPanel();
		panelPairPlusBoard.setBounds(124, 219, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPairPlusBoard);

		JLabel lblPairPlusBoard = new JLabel("0");
		lblPairPlusBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPairPlusBoard.add(lblPairPlusBoard);

		JPanel panelPlay = new JPanel();
		panelPlay.setBackground(new Color(0, 255, 0));
		panelPlay.setBounds(124, 252, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPlay);

		JLabel lblNewLabel_6 = new JLabel("Play Pot");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPlay.add(lblNewLabel_6);

		JPanel panelPlayBoard = new JPanel();
		panelPlayBoard.setBounds(124, 285, 105, 23);
		frmThreeCardPoker.getContentPane().add(panelPlayBoard);

		JLabel lblPlayBoard = new JLabel("0");
		lblPlayBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPlayBoard.add(lblPlayBoard);

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

		JLabel lblBankBoard = new JLabel(Integer.toString(money));
		lblBankBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBankBoard.add(lblBankBoard);
		
		JButton btnFold = new JButton("Fold");
		btnFold.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFold.setBounds(755, 129, 105, 23);
		frmThreeCardPoker.getContentPane().add(btnFold);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPlay.setBounds(755, 162, 105, 23);
		frmThreeCardPoker.getContentPane().add(btnPlay);
		
		JButton btnStart = new JButton("Game Start");
		btnStart.setFont(new Font("Arial", Font.PLAIN, 12));
		btnStart.setBounds(755, 96, 105, 23);
		frmThreeCardPoker.getContentPane().add(btnStart);
		
		JPanel panelHelper = new JPanel();
		panelHelper.setBounds(354, 298, 265, 32);
		frmThreeCardPoker.getContentPane().add(panelHelper);
		
		JLabel lblHelper = new JLabel("Press Start");
		panelHelper.add(lblHelper);
		
		JPanel panelDealerHandBoard = new JPanel();
		panelDealerHandBoard.setBounds(755, 239, 150, 23);
		frmThreeCardPoker.getContentPane().add(panelDealerHandBoard);
		
		JLabel lblDealerHandBoard = new JLabel("");
		lblDealerHandBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDealerHandBoard.add(lblDealerHandBoard);
		
		JPanel panelDealerHand = new JPanel();
		panelDealerHand.setBackground(Color.GREEN);
		panelDealerHand.setBounds(755, 206, 150, 23);
		frmThreeCardPoker.getContentPane().add(panelDealerHand);
		
		JLabel lblDealerHand = new JLabel("Dealer Hand");
		lblDealerHand.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDealerHand.add(lblDealerHand);
		
		JPanel panelGamerHandBoard = new JPanel();
		panelGamerHandBoard.setBounds(755, 307, 150, 23);
		frmThreeCardPoker.getContentPane().add(panelGamerHandBoard);
		
		JLabel lblGamerHandBoard = new JLabel("");
		lblGamerHandBoard.setFont(new Font("Arial", Font.PLAIN, 12));
		panelGamerHandBoard.add(lblGamerHandBoard);
		
		JPanel panelGamerHand = new JPanel();
		panelGamerHand.setBackground(Color.GREEN);
		panelGamerHand.setBounds(755, 274, 150, 23);
		frmThreeCardPoker.getContentPane().add(panelGamerHand);
		
		JLabel lblGamerHand = new JLabel("Gamer Hand");
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
		
		JLabel lblBackgroundLogo = new JLabel("");
		lblBackgroundLogo.setIcon(new ImageIcon(Main.class.getResource("/img/logo.png")));
		lblBackgroundLogo.setBounds(338, 173, 300, 300);
		frmThreeCardPoker.getContentPane().add(lblBackgroundLogo);
		
		forReplay.add(0, 0);
		
		//5$ chip
		chip5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phaseBet) {
					if(tempMoney >= 5) {
						_pot += 5;
						tempMoney = money - _pot;
						forReplay.add(_pot);
						lblPot.setText(Integer.toString(_pot));
						lblBankBoard.setText(Integer.toString(tempMoney));
					}
				}
			}
		});
		
		//25$ chip
		chip25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phaseBet) {
					if(tempMoney >= 25) {
						_pot += 25;
						tempMoney = money - _pot;
						forReplay.add(_pot);
						lblPot.setText(Integer.toString(_pot));
						lblBankBoard.setText(Integer.toString(tempMoney));
					}
				}
				
			}
		});
		
		//100$ chip
		chip100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phaseBet) {
					if(tempMoney >= 100) {
						_pot += 100;
						tempMoney = money - _pot;
						forReplay.add(_pot);
						lblPot.setText(Integer.toString(_pot));
						lblBankBoard.setText(Integer.toString(tempMoney));
					}
				}
			}
		});
		
		//500$ chip
		chip500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phaseBet) {
					if(tempMoney >= 500) {
						_pot += 500;
						tempMoney = money - _pot;
						forReplay.add(_pot);
						lblPot.setText(Integer.toString(_pot));
						lblBankBoard.setText(Integer.toString(tempMoney));
					}
				}
			}
		});
		
		//Reset Bet
		btnResetBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phaseBet) {
					forReplay.add(_pot);
					_pot = 0;
					tempMoney = money - _pot;
					lblPot.setText(Integer.toString(_pot));
					lblBankBoard.setText(Integer.toString(tempMoney));
				}
			}
		});
		
		//Replay Bet
		btnReplayBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phaseBet) {
					if(forReplay.size() > 1) {
						_pot = forReplay.get(forReplay.size() - 2);
						tempMoney = money - _pot;
						forReplay.remove(forReplay.size() - 1);
						lblPot.setText(Integer.toString(_pot));
						lblBankBoard.setText(Integer.toString(tempMoney));
					}
					else {
						_pot = 0;
						tempMoney = money - _pot;
						lblPot.setText(Integer.toString(_pot));
						lblBankBoard.setText(Integer.toString(tempMoney));
					}
				}
			}
		});
		
		panelPlayer0.setVisible(false);
		panelPlayer1.setVisible(false);
		
		//Game Start
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase == 0) {
					anteBet = 0;
					pairPlusBet = 0;
					playBet = 0;
					
					lblAnteBoard.setText("0");
					lblPairPlusBoard.setText("0");
					lblPlayBoard.setText("0");
					
					lblDealerHandBoard.setText("");
					lblGamerHandBoard.setText("");
					panelPlayer0.setVisible(false);
					panelPlayer1.setVisible(false);
					
					lblDCard1.setVisible(false);
					lblDCard2.setVisible(false);
					lblDCard3.setVisible(false);
					
					lblGCard1.setVisible(false);
					lblGCard2.setVisible(false);
					lblGCard3.setVisible(false);
					
					games++;
					System.out.println(games);
					System.out.println(wins);
					System.out.println(loses);
					lblHelper.setText("Input Ante Bet");
					phaseBet = true;
					tempMoney = money;
					phase = 1;
				}
			}
		});
		
		//Quit
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThreeCardPoker.dispose();
			}
		});
		
		//commit
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase == 1) {
					anteBet = _pot;
					money = tempMoney;
					lblAnteBoard.setText(Integer.toString(anteBet));
					_pot = 0;
					lblPot.setText(Integer.toString(_pot));
					
					forReplay = new ArrayList<>();
					forReplay.add(0,0);
					
					if(anteBet > 0) {
						lblHelper.setText("Input Pair+ Bet");
						phase = 2;
					}
					
					if(money == 0) {
						panelPlayer0.setVisible(true);
						panelPlayer1.setVisible(true);
						
						gamer.setHand(dealer.handOutCards());
						
						//핸드랭크 출력
						gamerResult = rule.judge(gamer.getHand());
						dealerResult = rule.judge(dealer.getHand());
						
						lblGamerHandBoard.setText(getStringResult(gamerResult));
						
						//카드 출력
						lblDCard1.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
						lblDCard2.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
						lblDCard3.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
						
						lblDCard1.setVisible(true);
						lblDCard2.setVisible(true);
						lblDCard3.setVisible(true);
						
						lblGCard1.setIcon(new ImageIcon(Main.class.getResource(getCardID(gamer.getHand()[0]))));
						lblGCard2.setIcon(new ImageIcon(Main.class.getResource(getCardID(gamer.getHand()[1]))));
						lblGCard3.setIcon(new ImageIcon(Main.class.getResource(getCardID(gamer.getHand()[2]))));
						
						lblGCard1.setVisible(true);
						lblGCard2.setVisible(true);
						lblGCard3.setVisible(true);
						
						lblHelper.setText("Fold or Play");
						phaseBet = false;
						
						//카드출력
						lblDCard1.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[0]))));
						lblDCard2.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[1]))));
						lblDCard3.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[2]))));
						
						lblDealerHandBoard.setText(getStringResult(dealerResult));
						
						rule.setWLResult(gamerResult, dealerResult);
						win = rule.getWin();
						
						if(win) {
							lblHelper.setText("You Won! Press Start");
							wins++;
						}
						else {
							lblHelper.setText("You Lost Press Start");
							loses++;
						}
						
						money += rule.pay(gamerResult, dealerResult, anteBet, playBet, pairPlusBet);
						lblBankBoard.setText(Integer.toString(money));
						
						if(money <= 0) {
							JOptionPane.showMessageDialog(null, "YOU DON'T HAVE MONEY!");
							frmThreeCardPoker.dispose();
						}
						
						lblAnteBoard.setText("0");
						lblPairPlusBoard.setText("0");
						lblPlayBoard.setText("0");
						
						lblWinsBoard.setText(Integer.toString(wins));
						lblLosesBoard.setText(Integer.toString(loses));
						
						winningRate = (double)wins / (double)games * 100;
						lblWinningRateBoard.setText(Double.toString(Math.round(winningRate * 10) / 10.0));
						System.out.println(winningRate);
						
						phase = 0;
					}
				}
				else if(phase == 2) {
					pairPlusBet = _pot;
					money = tempMoney;
					lblPairPlusBoard.setText(Integer.toString(pairPlusBet));
					_pot = 0;
					lblPot.setText(Integer.toString(_pot));
					
					forReplay = new ArrayList<>();
					forReplay.add(0,0);
					
					panelPlayer0.setVisible(true);
					panelPlayer1.setVisible(true);
					
					gamer.setHand(dealer.handOutCards());
					
					//핸드랭크 출력
					gamerResult = rule.judge(gamer.getHand());
					dealerResult = rule.judge(dealer.getHand());
					
					lblGamerHandBoard.setText(getStringResult(gamerResult));
					
					//카드 출력
					lblDCard1.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
					lblDCard2.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
					lblDCard3.setIcon(new ImageIcon(Main.class.getResource("/img/playing_cards/gray_back.png")));
					
					lblDCard1.setVisible(true);
					lblDCard2.setVisible(true);
					lblDCard3.setVisible(true);
					
					lblGCard1.setIcon(new ImageIcon(Main.class.getResource(getCardID(gamer.getHand()[0]))));
					lblGCard2.setIcon(new ImageIcon(Main.class.getResource(getCardID(gamer.getHand()[1]))));
					lblGCard3.setIcon(new ImageIcon(Main.class.getResource(getCardID(gamer.getHand()[2]))));
					
					lblGCard1.setVisible(true);
					lblGCard2.setVisible(true);
					lblGCard3.setVisible(true);
					
					lblHelper.setText("Fold or Play");
					phaseBet = false;
					phase = 3;
					
					if(money == 0) {
						//카드출력
						lblDCard1.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[0]))));
						lblDCard2.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[1]))));
						lblDCard3.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[2]))));
						
						lblDealerHandBoard.setText(getStringResult(dealerResult));
						
						rule.setWLResult(gamerResult, dealerResult);
						win = rule.getWin();
						
						if(win) {
							lblHelper.setText("You Won! Press Start");
							wins++;
						}
						else {
							lblHelper.setText("You Lost Press Start");
							loses++;
						}
						
						money += rule.pay(gamerResult, dealerResult, anteBet, playBet, pairPlusBet);
						lblBankBoard.setText(Integer.toString(money));
						
						if(money <= 0) {
							JOptionPane.showMessageDialog(null, "YOU DON'T HAVE MONEY!");
							frmThreeCardPoker.dispose();
						}
						
						lblAnteBoard.setText("0");
						lblPairPlusBoard.setText("0");
						lblPlayBoard.setText("0");
						
						lblWinsBoard.setText(Integer.toString(wins));
						lblLosesBoard.setText(Integer.toString(loses));
						
						winningRate = (double)wins / (double)games * 100;
						lblWinningRateBoard.setText(Double.toString(Math.round(winningRate * 10) / 10.0));
						System.out.println(winningRate);
						
						phase = 0;
					}
				}
			}
		});
		
		//Fold
		btnFold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase == 3) {
					lblDCard1.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[0]))));
					lblDCard2.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[1]))));
					lblDCard3.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[2]))));
					
					lblDealerHandBoard.setText(getStringResult(dealerResult));
					
					lblHelper.setText("You Folded Press Start");
					
					lblAnteBoard.setText("0");
					lblPairPlusBoard.setText("0");
					lblPlayBoard.setText("0");
					
					loses++;
					lblLosesBoard.setText(Integer.toString(loses));
					
					winningRate = (double)wins / (double)games * 100;
					lblWinningRateBoard.setText(Double.toString(Math.round(winningRate * 10) / 10.0));
					System.out.println(winningRate);
					
					if(money <= 0) {
						JOptionPane.showMessageDialog(null, "YOU DON'T HAVE MONEY!");
						frmThreeCardPoker.dispose();
					}
					phase = 0;
				}
			}
		});
		
		//Play
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase == 3) {
					if(money - anteBet >= 0) {
						money -= anteBet;
						playBet = anteBet;
						lblBankBoard.setText(Integer.toString(money));
						lblPlayBoard.setText(Integer.toString(playBet));
					}
					else {
						playBet = money;
						money = 0;
						lblBankBoard.setText(Integer.toString(money));
						lblPlayBoard.setText(Integer.toString(playBet));
					}
					
					//카드출력
					lblDCard1.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[0]))));
					lblDCard2.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[1]))));
					lblDCard3.setIcon(new ImageIcon(Main.class.getResource(getCardID(dealer.getHand()[2]))));
					
					lblDealerHandBoard.setText(getStringResult(dealerResult));
					
					rule.setWLResult(gamerResult, dealerResult);
					win = rule.getWin();
					
					if(win) {
						lblHelper.setText("You Won! Press Start");
						wins++;
					}
					else {
						lblHelper.setText("You Lost Press Start");
						loses++;
					}
					
					money += rule.pay(gamerResult, dealerResult, anteBet, playBet, pairPlusBet);
					lblBankBoard.setText(Integer.toString(money));
					
					if(money <= 0) {
						JOptionPane.showMessageDialog(null, "YOU DON'T HAVE MONEY!");
						frmThreeCardPoker.dispose();
					}
					
					lblWinsBoard.setText(Integer.toString(wins));
					lblLosesBoard.setText(Integer.toString(loses));
					
					winningRate = (double)wins / (double)games * 100;
					lblWinningRateBoard.setText(Double.toString(Math.round(winningRate * 10) / 10.0));
					System.out.println(winningRate);
					
					phase = 0;
					
				}
			}
		});
		
		frmThreeCardPoker.setResizable(false);
	}
	
	private String getStringResult(int[] result) {
		String forReturn = null;
		
		//number
		if(result[1] == 14) {
			forReturn = "A";
		}
		else if(result[1] == 13) {
			forReturn = "K";
		}
		else if(result[1] == 12) {
			forReturn = "Q";
		}
		else if(result[1] == 11) {
			forReturn = "J";
		}
		else {
			forReturn = Integer.toString(result[1]);
		}
		
		//shape
		if(result[0] == 3) {
			forReturn += "S";
		}
		else if(result[0] == 2) {
			forReturn += "D";
		}
		else if(result[0] == 1) {
			forReturn += "H";
		}
		else {
			forReturn += "C";
		}
		forReturn += " ";
		
		//rank
		if(result[2] == 0) {
			forReturn += "High Card";
		}
		else if(result[2] == 1) {
			forReturn += "One Pair";
		}
		else if(result[2] == 2) {
			forReturn += "Flush";
		}
		else if(result[2] == 3) {
			forReturn += "Straight";
		}
		else if(result[2] == 4) {
			forReturn += "Three of Kind";
		}
		else {
			forReturn += "Straight Flush";
		}
		
		return forReturn;
	}
	
	private String getCardID(Card card) {
		int shape = card.getShape();
		int number = card.getNumber();
		
		String forReturn = "/img/playing_cards/";
		
		if(number == 14) {
			forReturn += "A";
		}
		else if(number == 13) {
			forReturn += "K";
		}
		else if(number == 12) {
			forReturn += "Q";
		}
		else if(number == 11) {
			forReturn += "J";
		}
		else {
			forReturn += Integer.toString(number);
		}
		
		switch(shape) {
		case 3:
			forReturn += "S";
			break;
		case 2:
			forReturn += "D";
			break;
		case 1:
			forReturn += "H";
			break;
		case 0:
			forReturn += "C";
			break;
		}
		
		forReturn += ".png";
		
		return forReturn;
	}
}
