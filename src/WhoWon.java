
import java.util.ArrayList;
import java.util.Iterator;

public class WhoWon {

    // String suit;
    // int value;

    // public WhoWon(int value, String suit) {
    // this.value = value;
    // this.suit = suit;
    // }
    public static ArrayList<CardsDeck.Card> sortCards(ArrayList<CardsDeck.Card> sevenCardUnsorted) {

        ArrayList<CardsDeck.Card> tempCards = new ArrayList<>();
        for (int i = 2; i <= 14; i++) {
            for (CardsDeck.Card card : sevenCardUnsorted) {
                if (card.sortValue == i) {
                    tempCards.add(card);
                }
            }
        }
        return tempCards;
    }

    public static boolean flushCheck(ArrayList<CardsDeck.Card> inputFlush) {
        int[] flushChecker = { 0, 0, 0, 0 };
        boolean flushStatus = false;
        for (int i = 0; i < inputFlush.size(); i++) {
            if (inputFlush.get(i).getSuit().equals(CardsDeck.Suit.CLUBS)) {
                flushChecker[0] += 1;
            } else if (inputFlush.get(i).getSuit().equals(CardsDeck.Suit.DIAMONDS)) {
                flushChecker[1] += 1;
            } else if (inputFlush.get(i).getSuit().equals(CardsDeck.Suit.HEARTS)) {
                flushChecker[2] += 1;
            } else if (inputFlush.get(i).getSuit().equals(CardsDeck.Suit.SPADES)) {
                flushChecker[3] += 1;
            }
        }
        for (int i = 0; i < flushChecker.length; i++) {
            if (flushChecker[i] >= 5) {
                flushStatus = true;
            }
        }
        return flushStatus;

    }

    public static ArrayList<CardsDeck.Card> onlyFlushCards(ArrayList<CardsDeck.Card> inputOnlyFlush) {
        int[] flushChecker = { 0, 0, 0, 0 };
        for (int i = 0; i < inputOnlyFlush.size(); i++) {
            if (inputOnlyFlush.get(i).getSuit().equals(CardsDeck.Suit.CLUBS)) {
                flushChecker[0] += 1;
            } else if (inputOnlyFlush.get(i).getSuit().equals(CardsDeck.Suit.DIAMONDS)) {
                flushChecker[1] += 1;
            } else if (inputOnlyFlush.get(i).getSuit().equals(CardsDeck.Suit.HEARTS)) {
                flushChecker[2] += 1;
            } else if (inputOnlyFlush.get(i).getSuit().equals(CardsDeck.Suit.SPADES)) {
                flushChecker[3] += 1;
            }
        }
        for (int i = 0; i < flushChecker.length; i++) {
            if (flushChecker[i] >= 5 && i == 0) {
                System.out.println("flush clubs");

                for (Iterator<CardsDeck.Card> iterator = inputOnlyFlush.iterator(); iterator.hasNext();) {
                    CardsDeck.Card tcard = iterator.next();
                    if (tcard.getSuit().equals(CardsDeck.Suit.CLUBS) == false) {
                        iterator.remove();
                    }
                }

            } else if (flushChecker[i] >= 5 && i == 1) {
                System.out.println("flush diamonds");

                for (Iterator<CardsDeck.Card> iterator = inputOnlyFlush.iterator(); iterator.hasNext();) {
                    CardsDeck.Card tcard = iterator.next();
                    if (tcard.getSuit().equals(CardsDeck.Suit.DIAMONDS) == false) {
                        iterator.remove();
                    }
                }

            } else if (flushChecker[i] >= 5 && i == 2) {
                System.out.println("flush hearts");

                for (Iterator<CardsDeck.Card> iterator = inputOnlyFlush.iterator(); iterator.hasNext();) {
                    CardsDeck.Card tcard = iterator.next();
                    if (tcard.getSuit().equals(CardsDeck.Suit.HEARTS) == false) {
                        iterator.remove();
                    }
                }

            } else if (flushChecker[i] >= 5 && i == 2) {
                System.out.println("flush spade");

                for (Iterator<CardsDeck.Card> iterator = inputOnlyFlush.iterator(); iterator.hasNext();) {
                    CardsDeck.Card tcard = iterator.next();
                    if (tcard.getSuit().equals(CardsDeck.Suit.DIAMONDS) == false) {
                        iterator.remove();
                    }
                }

            }

        }
        return inputOnlyFlush;
    }

    public static boolean straightFlushCheck(ArrayList<CardsDeck.Card> inputFlushCheck) {
        boolean straightFlush = false;
        if (inputFlushCheck.size() == 7) {
            if (inputFlushCheck.get(6).sortValue - inputFlushCheck.get(2).sortValue == 4) {
                straightFlush = true;
            } else if (inputFlushCheck.get(5).sortValue - inputFlushCheck.get(1).sortValue == 4) {
                straightFlush = true;
            } else if (inputFlushCheck.get(4).sortValue - inputFlushCheck.get(0).sortValue == 4) {
                straightFlush = true;
            }
        } else if (inputFlushCheck.size() == 6) {
            if (inputFlushCheck.get(5).sortValue - inputFlushCheck.get(1).sortValue == 4) {
                straightFlush = true;
            } else if (inputFlushCheck.get(4).sortValue - inputFlushCheck.get(0).sortValue == 4) {
                straightFlush = true;
            }
        } else if (inputFlushCheck.size() == 5) {
            if (inputFlushCheck.get(4).sortValue - inputFlushCheck.get(0).sortValue == 4) {
                straightFlush = true;
            }
        } else if (inputFlushCheck.get(inputFlushCheck.size() - 1).sortValue == 14
                && inputFlushCheck.get(3).sortValue == 4) {
            straightFlush = true;
        }
        return straightFlush;

    }

    public static ArrayList<CardsDeck.Card> straightFlushTrimmer(ArrayList<CardsDeck.Card> inputStraightFlush) {
        if (inputStraightFlush.size() == 7) {
            if (inputStraightFlush.get(6).sortValue - inputStraightFlush.get(2).sortValue == 4) {
                inputStraightFlush.remove(0);
                inputStraightFlush.remove(0);
            } else if (inputStraightFlush.get(5).sortValue - inputStraightFlush.get(1).sortValue == 4) {
                inputStraightFlush.remove(6);
                inputStraightFlush.remove(0);
            } else if (inputStraightFlush.get(4).sortValue - inputStraightFlush.get(0).sortValue == 4) {
                inputStraightFlush.remove(6);
                inputStraightFlush.remove(5);
            }
        } else if (inputStraightFlush.size() == 6) {
            if (inputStraightFlush.get(5).sortValue - inputStraightFlush.get(1).sortValue == 4) {
                inputStraightFlush.remove(0);
            } else if (inputStraightFlush.get(4).sortValue - inputStraightFlush.get(0).sortValue == 4) {
                inputStraightFlush.remove(5);
            }
        } else if (inputStraightFlush.size() == 5) {
            if (inputStraightFlush.get(4).sortValue - inputStraightFlush.get(0).sortValue == 4) {
            }
        } else if (inputStraightFlush.get(inputStraightFlush.size() - 1).sortValue == 14
                && inputStraightFlush.get(3).sortValue == 4) /* Checking the wheel */ {
            if (inputStraightFlush.size() == 7) {
                inputStraightFlush.remove(4);
                inputStraightFlush.remove(4);
            } else if (inputStraightFlush.size() == 6) {
                inputStraightFlush.remove(4);
            }
        }
        return inputStraightFlush;
    }

    public static int quadsCheck(ArrayList<CardsDeck.Card> inputCards) {
        int hasQuads = -1;
        for (int i = 2; i <= 14; i++) {
            int quadCount = 0;
            for (CardsDeck.Card card : inputCards) {
                if (card.sortValue == i) {
                    quadCount += 1;
                    if (quadCount == 4) {
                        hasQuads = i;
                    }
                }
            }
        }
        return hasQuads;
    }

    public static ArrayList<CardsDeck.Card> quadsCards(ArrayList<CardsDeck.Card> inputCards, int hasQuads) {
        ArrayList<CardsDeck.Card> quadCards = new ArrayList<>();
        boolean kickerFound = false;
        for (int i = 14; i >= 2; i--) {
            for (CardsDeck.Card card : inputCards) {
                if (card.sortValue == hasQuads) {
                    quadCards.add(card);
                } else if (kickerFound == false) {
                    quadCards.add(card);
                    kickerFound = true;
                }
            }
        }
        return quadCards;
    }

    
    
    public static void calculate(ArrayList<Player> players, int pot, ArrayList<CardsDeck.Card> board) {

        for (Player player : players) {
            if (player.inHand == true) {

                ArrayList<CardsDeck.Card> sevenCardHand = new ArrayList<>();
                ArrayList<CardsDeck.Card> finalHand = new ArrayList<>();
                ArrayList<CardsDeck.Card> flushCheck = new ArrayList<>();
                Boolean hasStraightFlush = false;
                int hasQuads = -1;
                Boolean hasFlush = false;

                sevenCardHand.addAll(board);
                sevenCardHand.add(player.cardOne);
                sevenCardHand.add(player.cardTwo);
                sevenCardHand = sortCards(sevenCardHand);
                hasFlush = flushCheck(sevenCardHand);
                if (hasFlush == true) {
                    flushCheck = onlyFlushCards(sevenCardHand);
                    hasStraightFlush = straightFlushCheck(flushCheck);
                }
                if (hasStraightFlush = true) {
                    finalHand = straightFlushTrimmer(flushCheck);
                }
                hasQuads = quadsCheck(sevenCardHand);
                if (hasQuads != -1) {
                    finalHand = quadsCards(sevenCardHand, hasQuads);
                }

                int[] flushChecker = { 0, 0, 0, 0 };
                for (int i = 0; i < sevenCardHand.size(); i++) {
                    if (sevenCardHand.get(i).getSuit().equals(CardsDeck.Suit.CLUBS)) {
                        flushChecker[0] += 1;
                    } else if (sevenCardHand.get(i).getSuit().equals(CardsDeck.Suit.DIAMONDS)) {
                        flushChecker[1] += 1;
                    } else if (sevenCardHand.get(i).getSuit().equals(CardsDeck.Suit.HEARTS)) {
                        flushChecker[2] += 1;
                    } else if (sevenCardHand.get(i).getSuit().equals(CardsDeck.Suit.SPADES)) {
                        flushChecker[3] += 1;
                    }
                }
                for (int i = 0; i < flushChecker.length; i++) {
                    if (flushChecker[i] >= 5 && i == 0) {
                        System.out.println("flush clubs");
                        hasFlush = true;

                        for (Iterator<CardsDeck.Card> iterator = sevenCardHand.iterator(); iterator.hasNext();) {
                            CardsDeck.Card tcard = iterator.next();
                            if (tcard.getSuit().equals(CardsDeck.Suit.CLUBS) == false) {
                                iterator.remove();
                            }
                        }

                    } else if (flushChecker[i] >= 5 && i == 1) {
                        System.out.println("flush diamonds");
                        hasFlush = true;

                        for (Iterator<CardsDeck.Card> iterator = sevenCardHand.iterator(); iterator.hasNext();) {
                            CardsDeck.Card tcard = iterator.next();
                            if (tcard.getSuit().equals(CardsDeck.Suit.DIAMONDS) == false) {
                                iterator.remove();
                            }
                        }

                    } else if (flushChecker[i] >= 5 && i == 2) {
                        System.out.println("flush hearts");
                        hasFlush = true;

                        for (Iterator<CardsDeck.Card> iterator = sevenCardHand.iterator(); iterator.hasNext();) {
                            CardsDeck.Card tcard = iterator.next();
                            if (tcard.getSuit().equals(CardsDeck.Suit.HEARTS) == false) {
                                iterator.remove();
                            }
                        }

                    } else if (flushChecker[i] >= 5 && i == 2) {
                        System.out.println("flush spade");
                        hasFlush = true;

                        for (Iterator<CardsDeck.Card> iterator = sevenCardHand.iterator(); iterator.hasNext();) {
                            CardsDeck.Card tcard = iterator.next();
                            if (tcard.getSuit().equals(CardsDeck.Suit.DIAMONDS) == false) {
                                iterator.remove();
                            }
                        }

                    }

                }
                if (hasFlush == true) {
                    System.out.println("************We made a flush!");
                    if (sevenCardHand.size() == 7) {
                        sevenCardHand.remove(0);
                    }
                    if (sevenCardHand.size() == 6) {
                        sevenCardHand.remove(0);
                    }
                }
                System.out.println(sevenCardHand);

                System.out.println(finalHand);

            }

        }
    }

}
