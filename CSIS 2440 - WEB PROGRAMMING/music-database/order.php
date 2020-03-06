<?php
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

<?php include_once('../src/php/global_functions.php'); ?>

<!DOCTYPE html>
<html lang="en">
    <head> 
        <?php echo displayHead(); ?>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <!--NAV START-->
        <nav class="navbar navbar-expand-md bg-nav">
            <a href="../index.php" class="navbar-brand"><img src="img/iconfinder_icon_animal_cachorro_3316536.png"></a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">CSIS 2440</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="../happy-birthday/index.php">Happy Birthday</a>
                            <a class="dropdown-item" href="../music-database/index.php">Music Database</a>
                            <a class="dropdown-item" href="../validation/index.php">Validation</a>
                        </div>
                    </li>
                </ul>

                <div class="mr-3">
                    <form class="form-inline my-2 collapse navbar-collapse">
                        <input class="form-control mr-md-2" type="search" placeholder="Doesn't really search" aria-label="search">
                        <button class="btn btn-grey my-2" type="submit">Search</button>
                    </form>
                </div>   
            </div>
        </nav>
        <!--NAV END-->

        <div class="container">
            <div class="jumbotron">
                <h1>Order Confirmed</h1>
                <hr>
                <h2>Order Details:</h2>
                <?php
                    echo displayOrder();
                ?>
                <hr>
                <h2>Shipping To:</h2>
                <?php
                    echo displayRecipient();
                ?>
            </div>
        </div>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>