<?php
    // music.php
        $albums = array('The Getaway - Red Hot Chili Peppers', 'I\'m with You - Red Hot Chili Peppers',
            'Stadium Arcadium', 'By the Way - Red Hot Chili Peppers', 'Californication - Red Hot Chili Peppers',
            'Cabin By the Sea - Dirty Heads', 'Sublime - Sublime', 'Dirty Heads - Dirty Heads',
            'Sirens - Dirty Heads', 'Sound Of Change - Dirty Heads');

        function displayTable()
        {
            global $albums;
            $table = "";

            foreach ($albums as $album) {
                $table .= "<tr><td>$album</td></tr>";
            }

            return $table;
        }
    
    // products.php
        $isError = false;
        $err = "All fields with a * are required";

        $bands = array("Red Hot Chili Peppers", "Sublime", "Slipknot", "Disturbed", "Bob Marley");
        $colors = array("Black", "Red", "Green", "White", "Blue");
        $sizes = array("XS", "S", "M", "L", "XL");
        $styles = array("Polo", "T-Shirt", "Long Sleeve", "Slim Fit", "Hoodie");

        if(!empty($_GET)){
            $isError = true;
        }
        
    
    // order.php
        if(!empty($_POST['band']) and !empty($_POST['color']) and !empty($_POST['size'])
            and !empty($_POST['style']) and !empty($_POST['firstName']) and !empty($_POST['lastName'])
            and !empty($_POST['email']) and !empty($_POST['telephone']) and !empty($_POST['address1'])
            and !empty($_POST['city']) and !empty($_POST['state']) and !empty($_POST['postal_code'])){
                function displayOrder(){
                    $order = "";
                    $order .= "Band: $_POST[band]<br>";
                    $order .= "Color: $_POST[color]<br>";
                    $order .= "Size: $_POST[size]<br>";
                    $order .= "Style: $_POST[style]<br>";
            
                    return $order;
                }
            
                function displayRecipient(){
                    $msg = "";
                    $msg .= "Name: $_POST[firstName] $_POST[lastName]<br>";
                    $msg .= "Email: $_POST[email]<br>";
                    $msg .= "Telephone: $_POST[telephone]<br>";
                    $msg .= "Address: $_POST[address1]<br>$_POST[address2]<br>";
                    $msg .= "City: $_POST[city]<br>";
                    $msg .= "State / Province / Region: $_POST[state]<br>";
                    $msg .= "Postal Code: $_POST[postal_code]<br><br>";
            
                    return $msg;
                }        
        }
        else {
            header("location: products.php?band=$_POST[band]&color=$_POST[color]&size=$_POST[size]&style=$_POST[style]&firstName=$_POST[firstName]&lastName=$_POST[lastName]&email=$_POST[email]&telephone=$_POST[telephone]&address1=$_POST[address1]&address2=$_POST[address2]&city=$_POST[city]&state=$_POST[state]&postal_code=$_POST[postal_code]");
        }


?>
