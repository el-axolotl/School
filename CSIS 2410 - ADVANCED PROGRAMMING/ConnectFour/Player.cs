using System;

namespace ConnectFour
{
    /// <summary>
    /// Christopher Munoz & Frank Kelly
    /// Creates Player objects. It can return the name, and handle insertion of
    /// chips in the Connect Four Board.
    /// </summary>
    public class Player
    {
        public int[,] slots = new int[7, 6];
        int temp;
        public string Name { get; }
        public ConsoleColor Color { get; }

        /// <summary>
        /// Constructs a Player object.
        /// </summary>
        /// <param name="playerName">Player name.</param>
        public Player(string playerName, ConsoleColor color)
        {
            Name = playerName;
            Color = color;

            // initialize empty slots
            for (int i = 0; i < 7; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    // slots[column][row]
                    slots[i, j] = 0;
                }
            }
        }

        /// <summary>
        /// Handles the insertion of chips on the Connect Four Board.
        /// </summary>
        /// <param name="column">Column.</param>
        public void Insert(int column)
        {
            while (Board.columns[column - 1] < 6)                               // This segment of code makes sure that
            {                                                                   // columns don't get overfilled.
                Board.InvalidColumn(Name);                                      //
                while ((!int.TryParse(Console.ReadLine(), out column))          //
                || column < 1 || column > 7)                                    //
                {                                                               //
                    Board.InvalidColumn(Name);                                  //
                }                                                               //
            }                                                                   //

            int verticalPosition;
            temp = column - 1;
            switch (column)
            {
                case 1:
                    verticalPosition = (int)Math.Pow(column, 2) + 1;
                    Animate(verticalPosition, column);
                    break;
                case 2:
                    verticalPosition = (int)Math.Pow(column, 2) + 2;
                    Animate(verticalPosition, column);
                    break;
                case 3:
                    verticalPosition = (int)Math.Pow(column, 2) + 1;
                    Animate(verticalPosition, column);
                    break;
                case 4:

                    verticalPosition = (int)Math.Pow(column, 2) - 2;
                    Animate(verticalPosition, column);
                    break;
                case 5:
                    verticalPosition = (int)Math.Pow(column, 2) - 7;
                    Animate(verticalPosition, column);
                    break;
                case 6:
                    verticalPosition = (int)Math.Pow(column, 2) - 14;
                    Animate(verticalPosition, column);
                    break;
                case 7:
                    verticalPosition = (int)Math.Pow(column, 2) - 23;
                    Animate(verticalPosition, column);
                    break;
            }
        }

        /// <summary>
        /// Mimics dropping a Chip onto the column of your choice.
        /// </summary>
        /// <param name="choice">Choice.</param> Sets the vertical position on
        /// the Console.
        /// <param name="columnSlots">Column.</param> Keeps track of how many 
        /// chips are on the column.
        private void Animate(int choice, int columnSlots)
        {
            for (int i = 6; i <= Board.columns[columnSlots - 1]; i++)
            {
                if (i < Board.columns[columnSlots - 1])
                {
                    Console.SetCursorPosition(choice, i);
                    Console.ForegroundColor = Color;
                    Console.Write("O");
                    System.Threading.Thread.Sleep(300);

                    Console.SetCursorPosition(choice, i);
                    Console.ResetColor();
                    Console.Write(" ");
                }

                else
                {
                    slots[temp, Board.columns[columnSlots - 1] - 6] = 1;

                    Console.SetCursorPosition(choice,
                        Board.columns[columnSlots - 1]--);
                    Console.ForegroundColor = Color;
                    Console.Write("O");
                    Board.RemainingSlots--;
                }
            }
        }


        public bool Win()
        {
            int consecutive = 0;

            // check vertical win condition
            for (int i = 0; i < 7; i++)
            {

                consecutive = 0;
                for (int j = 0; j < 6; j++)
                {
                    if (slots[i, j] == 1)
                    {
                        if (++consecutive == 4)
                        {
                            return true;
                        }
                    }
                    else
                    {
                        consecutive = 0;
                    }
                }
            }

            // check horizontal win condition

            for (int j = 0; j < 6; j++)
            {

                consecutive = 0;
                for (int i = 0; i < 7; i++)
                {
                    if (slots[i, j] == 1)
                    {
                        if (++consecutive == 4)
                        {
                            return true;
                        }
                    }
                    else
                    {
                        consecutive = 0;
                    }
                }
            }

            // check diagonal down and right win condition
            for (int i = 0; i < 7; i++)
            {
                for (int j = 0; j < 6; j++)
                {

                    if (slots[i, j] == 1)
                    {
                        int counter = 1;
                        consecutive = 1;
                        while (i + counter < 7 && j + counter < 6)
                        {

                            if (slots[i + counter, j + counter] == 1)
                            {
                                if (++consecutive == 4)
                                {
                                    return true;
                                }
                            }
                            else
                            {
                                break;
                            }
                            counter++;
                        }
                    }
                }
            }


            // check diagonal down and left win condition
            for (int i = 0; i < 7; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    if (slots[i, j] == 1)
                    {
                        int counter = 1;
                        consecutive = 1;
                        while (j + counter < 6 && i - counter >= 0)
                        {
                            if (slots[i - counter, j + counter] == 1)
                            {
                                if (++consecutive == 4)
                                {
                                    return true;
                                }
                            }
                            else
                            {
                                break;
                            }
                            counter++;
                        }

                    }

                }
            }

            return false;
        }
    }
}