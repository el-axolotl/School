namespace Crossword_Puzzle
{
    partial class GUI
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle4 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle5 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle6 = new System.Windows.Forms.DataGridViewCellStyle();
            this.mainMenu = new System.Windows.Forms.MenuStrip();
            this.fileSubMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.restartMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saveAsMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.optionsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.seeStatsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saveFileDialog = new System.Windows.Forms.SaveFileDialog();
            this.splitContainer = new System.Windows.Forms.SplitContainer();
            this.btnPlay = new System.Windows.Forms.Button();
            this.btnPause = new System.Windows.Forms.Button();
            this.lblSeconds = new System.Windows.Forms.Label();
            this.lblSemiColon = new System.Windows.Forms.Label();
            this.lblMinutes = new System.Windows.Forms.Label();
            this.clueGrid = new System.Windows.Forms.DataGridView();
            this.numberColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.directionColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.clueColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.puzzleGrid = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column11 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column12 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column13 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column14 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column15 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column16 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column17 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column18 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column19 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column20 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column8 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column9 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column10 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.lblScoreWords = new System.Windows.Forms.Label();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.lblPoints = new System.Windows.Forms.Label();
            this.mainMenu.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer)).BeginInit();
            this.splitContainer.Panel1.SuspendLayout();
            this.splitContainer.Panel2.SuspendLayout();
            this.splitContainer.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.clueGrid)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.puzzleGrid)).BeginInit();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // mainMenu
            // 
            this.mainMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileSubMenu,
            this.optionsToolStripMenuItem});
            this.mainMenu.Location = new System.Drawing.Point(0, 0);
            this.mainMenu.Name = "mainMenu";
            this.mainMenu.Size = new System.Drawing.Size(791, 24);
            this.mainMenu.TabIndex = 0;
            this.mainMenu.Text = "menuStrip1";
            // 
            // fileSubMenu
            // 
            this.fileSubMenu.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.restartMenuItem,
            this.saveAsMenuItem});
            this.fileSubMenu.Name = "fileSubMenu";
            this.fileSubMenu.Size = new System.Drawing.Size(37, 20);
            this.fileSubMenu.Text = "File";
            // 
            // restartMenuItem
            // 
            this.restartMenuItem.Name = "restartMenuItem";
            this.restartMenuItem.Size = new System.Drawing.Size(121, 22);
            this.restartMenuItem.Text = "Restart";
            this.restartMenuItem.Click += new System.EventHandler(this.restartMenuItem_Click);
            // 
            // saveAsMenuItem
            // 
            this.saveAsMenuItem.Name = "saveAsMenuItem";
            this.saveAsMenuItem.Size = new System.Drawing.Size(121, 22);
            this.saveAsMenuItem.Text = "Save as...";
            this.saveAsMenuItem.Click += new System.EventHandler(this.saveAsMenuItem_Click);
            // 
            // optionsToolStripMenuItem
            // 
            this.optionsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.seeStatsToolStripMenuItem});
            this.optionsToolStripMenuItem.Name = "optionsToolStripMenuItem";
            this.optionsToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.optionsToolStripMenuItem.Text = "Options";
            // 
            // seeStatsToolStripMenuItem
            // 
            this.seeStatsToolStripMenuItem.Name = "seeStatsToolStripMenuItem";
            this.seeStatsToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.seeStatsToolStripMenuItem.Text = "Scores";
            this.seeStatsToolStripMenuItem.Click += new System.EventHandler(this.seeStatsToolStripMenuItem_Click);
            // 
            // splitContainer
            // 
            this.splitContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer.Location = new System.Drawing.Point(0, 24);
            this.splitContainer.Name = "splitContainer";
            // 
            // splitContainer.Panel1
            // 
            this.splitContainer.Panel1.Controls.Add(this.tableLayoutPanel1);
            this.splitContainer.Panel1.Controls.Add(this.lblMinutes);
            this.splitContainer.Panel1.Controls.Add(this.btnPlay);
            this.splitContainer.Panel1.Controls.Add(this.btnPause);
            this.splitContainer.Panel1.Controls.Add(this.lblSeconds);
            this.splitContainer.Panel1.Controls.Add(this.lblSemiColon);
            this.splitContainer.Panel1.Controls.Add(this.clueGrid);
            // 
            // splitContainer.Panel2
            // 
            this.splitContainer.Panel2.Controls.Add(this.puzzleGrid);
            this.splitContainer.Size = new System.Drawing.Size(791, 488);
            this.splitContainer.SplitterDistance = 341;
            this.splitContainer.TabIndex = 1;
            // 
            // btnPlay
            // 
            this.btnPlay.Enabled = false;
            this.btnPlay.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnPlay.Location = new System.Drawing.Point(192, 418);
            this.btnPlay.Name = "btnPlay";
            this.btnPlay.Size = new System.Drawing.Size(75, 70);
            this.btnPlay.TabIndex = 7;
            this.btnPlay.Text = "PLAY";
            this.btnPlay.UseVisualStyleBackColor = true;
            this.btnPlay.Click += new System.EventHandler(this.btnPlay_Click);
            // 
            // btnPause
            // 
            this.btnPause.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnPause.Location = new System.Drawing.Point(258, 418);
            this.btnPause.Name = "btnPause";
            this.btnPause.Size = new System.Drawing.Size(83, 69);
            this.btnPause.TabIndex = 6;
            this.btnPause.Text = "PAUSE";
            this.btnPause.UseVisualStyleBackColor = true;
            this.btnPause.Click += new System.EventHandler(this.btnPause_Click);
            // 
            // lblSeconds
            // 
            this.lblSeconds.AutoSize = true;
            this.lblSeconds.Font = new System.Drawing.Font("Microsoft Sans Serif", 45F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSeconds.Location = new System.Drawing.Point(99, 419);
            this.lblSeconds.Name = "lblSeconds";
            this.lblSeconds.Size = new System.Drawing.Size(96, 69);
            this.lblSeconds.TabIndex = 4;
            this.lblSeconds.Text = "00";
            // 
            // lblSemiColon
            // 
            this.lblSemiColon.AutoSize = true;
            this.lblSemiColon.Font = new System.Drawing.Font("Microsoft Sans Serif", 45F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSemiColon.Location = new System.Drawing.Point(70, 418);
            this.lblSemiColon.Name = "lblSemiColon";
            this.lblSemiColon.Size = new System.Drawing.Size(47, 69);
            this.lblSemiColon.TabIndex = 3;
            this.lblSemiColon.Text = ":";
            // 
            // lblMinutes
            // 
            this.lblMinutes.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.lblMinutes.AutoSize = true;
            this.lblMinutes.Font = new System.Drawing.Font("Microsoft Sans Serif", 45F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblMinutes.Location = new System.Drawing.Point(-12, 419);
            this.lblMinutes.Name = "lblMinutes";
            this.lblMinutes.Size = new System.Drawing.Size(96, 69);
            this.lblMinutes.TabIndex = 2;
            this.lblMinutes.Text = "00";
            // 
            // clueGrid
            // 
            this.clueGrid.AllowUserToAddRows = false;
            this.clueGrid.AllowUserToDeleteRows = false;
            this.clueGrid.AllowUserToResizeColumns = false;
            this.clueGrid.AllowUserToResizeRows = false;
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle1.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle1.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.clueGrid.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            this.clueGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.clueGrid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.numberColumn,
            this.directionColumn,
            this.clueColumn});
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = System.Drawing.SystemColors.Window;
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle2.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.clueGrid.DefaultCellStyle = dataGridViewCellStyle2;
            this.clueGrid.Location = new System.Drawing.Point(0, 0);
            this.clueGrid.Name = "clueGrid";
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle3.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle3.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle3.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle3.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle3.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.clueGrid.RowHeadersDefaultCellStyle = dataGridViewCellStyle3;
            this.clueGrid.RowHeadersVisible = false;
            this.clueGrid.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.clueGrid.Size = new System.Drawing.Size(341, 337);
            this.clueGrid.TabIndex = 0;
            // 
            // numberColumn
            // 
            this.numberColumn.HeaderText = "#";
            this.numberColumn.Name = "numberColumn";
            this.numberColumn.ReadOnly = true;
            this.numberColumn.Width = 30;
            // 
            // directionColumn
            // 
            this.directionColumn.HeaderText = "Direction";
            this.directionColumn.Name = "directionColumn";
            this.directionColumn.ReadOnly = true;
            this.directionColumn.Width = 60;
            // 
            // clueColumn
            // 
            this.clueColumn.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.clueColumn.HeaderText = "Clue";
            this.clueColumn.Name = "clueColumn";
            this.clueColumn.ReadOnly = true;
            // 
            // puzzleGrid
            // 
            this.puzzleGrid.AllowUserToAddRows = false;
            this.puzzleGrid.AllowUserToDeleteRows = false;
            this.puzzleGrid.AllowUserToResizeColumns = false;
            this.puzzleGrid.AllowUserToResizeRows = false;
            dataGridViewCellStyle4.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle4.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle4.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle4.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle4.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle4.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle4.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.puzzleGrid.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle4;
            this.puzzleGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.puzzleGrid.ColumnHeadersVisible = false;
            this.puzzleGrid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column11,
            this.Column12,
            this.Column13,
            this.Column14,
            this.Column15,
            this.Column16,
            this.Column17,
            this.Column18,
            this.Column19,
            this.Column20,
            this.Column2,
            this.Column3,
            this.Column4,
            this.Column5,
            this.Column6,
            this.Column7,
            this.Column8,
            this.Column9,
            this.Column10});
            dataGridViewCellStyle5.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle5.BackColor = System.Drawing.SystemColors.Window;
            dataGridViewCellStyle5.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle5.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle5.Padding = new System.Windows.Forms.Padding(1);
            dataGridViewCellStyle5.SelectionBackColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle5.SelectionForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle5.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.puzzleGrid.DefaultCellStyle = dataGridViewCellStyle5;
            this.puzzleGrid.Dock = System.Windows.Forms.DockStyle.Fill;
            this.puzzleGrid.Location = new System.Drawing.Point(0, 0);
            this.puzzleGrid.Name = "puzzleGrid";
            dataGridViewCellStyle6.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle6.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle6.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle6.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle6.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle6.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle6.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.puzzleGrid.RowHeadersDefaultCellStyle = dataGridViewCellStyle6;
            this.puzzleGrid.RowHeadersVisible = false;
            this.puzzleGrid.ScrollBars = System.Windows.Forms.ScrollBars.None;
            this.puzzleGrid.Size = new System.Drawing.Size(446, 488);
            this.puzzleGrid.TabIndex = 0;
            this.puzzleGrid.CellPainting += new System.Windows.Forms.DataGridViewCellPaintingEventHandler(this.CellPainting);
            this.puzzleGrid.CellValueChanged += new System.Windows.Forms.DataGridViewCellEventHandler(this.CellValueChanged);
            // 
            // Column1
            // 
            this.Column1.HeaderText = "Column1";
            this.Column1.Name = "Column1";
            this.Column1.ReadOnly = true;
            // 
            // Column11
            // 
            this.Column11.HeaderText = "Column11";
            this.Column11.Name = "Column11";
            // 
            // Column12
            // 
            this.Column12.HeaderText = "Column12";
            this.Column12.Name = "Column12";
            // 
            // Column13
            // 
            this.Column13.HeaderText = "Column13";
            this.Column13.Name = "Column13";
            // 
            // Column14
            // 
            this.Column14.HeaderText = "Column14";
            this.Column14.Name = "Column14";
            // 
            // Column15
            // 
            this.Column15.HeaderText = "Column15";
            this.Column15.Name = "Column15";
            // 
            // Column16
            // 
            this.Column16.HeaderText = "Column16";
            this.Column16.Name = "Column16";
            // 
            // Column17
            // 
            this.Column17.HeaderText = "Column17";
            this.Column17.Name = "Column17";
            // 
            // Column18
            // 
            this.Column18.HeaderText = "Column18";
            this.Column18.Name = "Column18";
            // 
            // Column19
            // 
            this.Column19.HeaderText = "Column19";
            this.Column19.Name = "Column19";
            // 
            // Column20
            // 
            this.Column20.HeaderText = "Column20";
            this.Column20.Name = "Column20";
            // 
            // Column2
            // 
            this.Column2.HeaderText = "Column2";
            this.Column2.Name = "Column2";
            this.Column2.ReadOnly = true;
            // 
            // Column3
            // 
            this.Column3.HeaderText = "Column3";
            this.Column3.Name = "Column3";
            this.Column3.ReadOnly = true;
            // 
            // Column4
            // 
            this.Column4.HeaderText = "Column4";
            this.Column4.Name = "Column4";
            this.Column4.ReadOnly = true;
            // 
            // Column5
            // 
            this.Column5.HeaderText = "Column5";
            this.Column5.Name = "Column5";
            this.Column5.ReadOnly = true;
            // 
            // Column6
            // 
            this.Column6.HeaderText = "Column6";
            this.Column6.Name = "Column6";
            this.Column6.ReadOnly = true;
            // 
            // Column7
            // 
            this.Column7.HeaderText = "Column7";
            this.Column7.Name = "Column7";
            this.Column7.ReadOnly = true;
            // 
            // Column8
            // 
            this.Column8.HeaderText = "Column8";
            this.Column8.Name = "Column8";
            this.Column8.ReadOnly = true;
            // 
            // Column9
            // 
            this.Column9.HeaderText = "Column9";
            this.Column9.Name = "Column9";
            this.Column9.ReadOnly = true;
            // 
            // Column10
            // 
            this.Column10.HeaderText = "Column10";
            this.Column10.Name = "Column10";
            this.Column10.ReadOnly = true;
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // lblScoreWords
            // 
            this.lblScoreWords.AutoSize = true;
            this.lblScoreWords.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lblScoreWords.Font = new System.Drawing.Font("Microsoft Sans Serif", 25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblScoreWords.Location = new System.Drawing.Point(3, 0);
            this.lblScoreWords.Name = "lblScoreWords";
            this.lblScoreWords.Size = new System.Drawing.Size(164, 81);
            this.lblScoreWords.TabIndex = 8;
            this.lblScoreWords.Text = "SCORE: ";
            this.lblScoreWords.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 2;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Controls.Add(this.lblScoreWords, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.lblPoints, 1, 0);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 335);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 1;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(341, 81);
            this.tableLayoutPanel1.TabIndex = 9;
            // 
            // lblPoints
            // 
            this.lblPoints.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.lblPoints.AutoSize = true;
            this.lblPoints.Font = new System.Drawing.Font("Microsoft Sans Serif", 25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPoints.Location = new System.Drawing.Point(237, 21);
            this.lblPoints.Name = "lblPoints";
            this.lblPoints.Size = new System.Drawing.Size(36, 39);
            this.lblPoints.TabIndex = 9;
            this.lblPoints.Text = "0";
            this.lblPoints.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // GUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(791, 512);
            this.Controls.Add(this.splitContainer);
            this.Controls.Add(this.mainMenu);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MainMenuStrip = this.mainMenu;
            this.MaximizeBox = false;
            this.Name = "GUI";
            this.Text = "Crossword Puzzle";
            this.Load += new System.EventHandler(this.GUI_Load);
            this.mainMenu.ResumeLayout(false);
            this.mainMenu.PerformLayout();
            this.splitContainer.Panel1.ResumeLayout(false);
            this.splitContainer.Panel1.PerformLayout();
            this.splitContainer.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer)).EndInit();
            this.splitContainer.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.clueGrid)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.puzzleGrid)).EndInit();
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip mainMenu;
        private System.Windows.Forms.ToolStripMenuItem fileSubMenu;
        private System.Windows.Forms.ToolStripMenuItem restartMenuItem;
        private System.Windows.Forms.ToolStripMenuItem saveAsMenuItem;
        private System.Windows.Forms.SaveFileDialog saveFileDialog;
        private System.Windows.Forms.SplitContainer splitContainer;
        private System.Windows.Forms.DataGridView puzzleGrid;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column11;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column12;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column13;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column14;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column15;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column16;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column17;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column18;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column19;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column20;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column4;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column5;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column6;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column7;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column8;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column9;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column10;
        private System.Windows.Forms.DataGridView clueGrid;
        private System.Windows.Forms.DataGridViewTextBoxColumn numberColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn directionColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn clueColumn;
        private System.Windows.Forms.Label lblMinutes;
        private System.Windows.Forms.Label lblSeconds;
        private System.Windows.Forms.Label lblSemiColon;
        private System.Windows.Forms.Button btnPause;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Button btnPlay;
        private System.Windows.Forms.ToolStripMenuItem optionsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem seeStatsToolStripMenuItem;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Label lblScoreWords;
        private System.Windows.Forms.Label lblPoints;
    }
}

