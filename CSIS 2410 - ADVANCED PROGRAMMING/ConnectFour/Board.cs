using System;

namespace ConnectFour
{
    /// <summary>
    /// Christopher Munoz & Frank Kelly
    /// Creates a Connect Four Board.
    /// </summary>
    class Board
    {
        static int p1wins = 0;
        static int p2wins = 0;
        static Player p1;
        static Player p2;
        public static string columnPrompt;
        public static int RemainingSlots { get; set; } = 42;
        static int turnController = 1;
        public static int column1 { get; set; } = 11;
        public static int column2 { get; set; } = 11;
        public static int column3 { get; set; } = 11;
        public static int column4 { get; set; } = 11;
        public static int column5 { get; set; } = 11;
        public static int column6 { get; set; } = 11;
        public static int column7 { get; set; } = 11;
        public static int[] columns = {column1, column2, column3, column4,
            column5, column6, column7};

        static void Main(string[] args)
        {
            DisplayTitle();
            SetPlayers();
            DrawBoard();

            while (RemainingSlots > 0)
            {
                Interaction();
            }

            Console.SetCursorPosition(0, 15);
        }

        /// <summary>
        /// Prompts players for their name.
        /// </summary>
        static void SetPlayers()
        {
            //Console.WriteLine("Player 1");
            //Console.Write("Please enter name: ");
            //string p1Name = Console.ReadLine();
            //p1 = new Player(p1Name, ConsoleColor.Red);
            for (int i = 1; i < 3; i++)
            {
                Console.Clear();
                DisplayTitle();
                Console.WriteLine("Player " + i);
                Console.Write("Please enter name: ");
                string pName = Console.ReadLine();

                if (i == 1)
                {
                    p1 = new Player(pName, ConsoleColor.Red);
                }
                else
                {
                    p2 = new Player(pName, ConsoleColor.Cyan);
                }
            }
        }

        /// <summary>
        /// Creates a Connect Four board with 6 Rows and 7 Columns. It also
        /// displays at the top of each row, which column it is, to make it 
        /// easier for players to know what column they want to drop their chip
        /// on.
        /// </summary>
        static void DrawBoard()
        {
            Console.ResetColor();
            Console.Clear();
            DisplayTitle();

            Console.SetCursorPosition(0, 2);
            Console.Write(string.Format("{0}, you are ", p1.Name));
            Console.ForegroundColor = p1.Color;
            Console.WriteLine("O");
            Console.ResetColor();

            Console.Write(string.Format("{0}, you are ", p2.Name));
            Console.ForegroundColor = p2.Color;
            Console.WriteLine("O");
            Console.ResetColor();

            Console.SetCursorPosition(0, 5);
            Console.Write("  1   2   3   4   5   6   7");

            int row = 6;

            for (int i = 0; i < 6; i++)
            {
                Console.SetCursorPosition(0, row++);
                for (int j = 0; j < 8; j++)
                {
                    Console.Write("|   ");
                }
                Console.WriteLine();
            }
        }

        /// <summary>
        /// Displays the title.
        /// </summary>
        static void DisplayTitle()
        {
            Console.SetCursorPosition(7, 0);
            Console.WriteLine("Connect Four");
        }

        /// <summary>
        /// Asks the player what column they want to place their chip. It will
        /// display the name of who's turn it is.
        /// </summary>
        static void Interaction()
        {
            if (turnController % 2 != 0)                                        // Triggers Player 1's turn.
            {
                Console.SetCursorPosition(0, 12);
                Prompt(p1);
            }
            else                                                                // Triggers Player 2's turn.
            {
                Console.SetCursorPosition(0, 12);
                Prompt(p2);
            }
        }

        /// <summary>
        /// Prompt the specified player to enter a column to drop their chip.
        /// </summary>
        /// <param name="player">Player.</param>
        static void Prompt(Player player)
        {
            int column;

            if (columnPrompt != null)
            {
                ClearLine();
            }

            columnPrompt = string.Format("{0}, enter column between 1 - 7: ",
            player.Name);
            Console.Write(columnPrompt);

            while ((!int.TryParse(Console.ReadLine(), out column)) || column
                < 1 || column > 7)
            {
                InvalidColumn(player.Name);
            }

            Console.ForegroundColor = player.Color;
            player.Insert(column);

            if (player.Win())
            {


                if (player.Color == ConsoleColor.Red)
                {
                    p1wins++;
                }
                else
                {
                    p2wins++;
                }

                DrawBoard();
                ResetGame();
                Console.SetCursorPosition(30, 20);
                Console.ForegroundColor = player.Color;
                Console.WriteLine(player.Name + " WINS!");
                Console.ForegroundColor = ConsoleColor.White;
                Console.SetCursorPosition(0, 20);
                Console.WriteLine(p1.Name + ": " + p1wins + " win(s)");
                Console.WriteLine(p2.Name + ": " + p2wins + " win(s)");


            }

            if (StaleMate())
            {

                DrawBoard();
                ResetGame();
                Console.ForegroundColor = ConsoleColor.White;
                Console.SetCursorPosition(30, 20);
                Console.WriteLine("STALEMATE");
                Console.ForegroundColor = ConsoleColor.White;
                Console.SetCursorPosition(0, 20);
                Console.WriteLine(p1.Name + ": " + p1wins + " win(s)");
                Console.WriteLine(p2.Name + ": " + p2wins + " win(s)");
            }

            Console.ResetColor();
            turnController++;
        }

        /// <summary>
        /// Clears the console after each Prompt for input.
        /// </summary>
        public static void ClearLine()
        {
            Console.ResetColor();
            for (int i = 0; i <= columnPrompt.Length + 30; i++)
            {
                Console.Write(" ");
            }
            Console.SetCursorPosition(0, 12);
        }

        public static void InvalidColumn(string name)
        {
            ClearLine();
            columnPrompt = null;
            columnPrompt = string.Format("{0}, that was invalid. ",
                name);
            columnPrompt += "Enter column between 1 - 7: ";
            Console.Write(Board.columnPrompt);
        }

        static bool StaleMate()
        {
            return RemainingSlots == 0;
        }

        static void ResetGame()
        {
            for (int i = 0; i < columns.Length; i++)
            {
                columns[i] = 11;
            }

            RemainingSlots = 42;

            for (int i = 0; i < 7; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    // slots[column][row]
                    p1.slots[i, j] = 0;
                }
            }

            for (int i = 0; i < 7; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    // slots[column][row]
                    p2.slots[i, j] = 0;
                }
            }
        }
    }
}
