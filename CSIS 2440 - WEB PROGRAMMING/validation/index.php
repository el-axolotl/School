<?php
    $emailMsg = "<h4 class=\"required\">Please enter a valid email<h4>";
    $numberMsg = "<h4 class=\"required\">Please enter a valid phone number<h4>";
?>

<?php include_once('../src/php/global_functions.php'); ?>

<!DOCTYPE html>
<html lang="en">
    <head> 
        <?php echo displayHead(); ?>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
    <!--NAV-->
    <nav class="navbar navbar-expand-md bg-nav">
            <a href="../index.php" class="navbar-brand"><img src="../src/img/iconfinder_icon_animal_cachorro_3316536.png"></a>

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
                <?php
                    if(isset($_GET['er'])){
                        if($_GET['er'] === "v2fBmTtpB"){
                            echo "<h1 class='required'>$emailMsg</h1><br><h1 class='required'>$numberMsg</h1>";
                        }
                        else if($_GET['er'] === "euKFwpN4N"){
                            echo "<h1 class='required'>$numberMsg</h1>";
                        }
                        else if($_GET['er'] === "Qn0tMjWzE"){
                            echo "<h1 class='required'>$emailMsg</h1>";
                        }
                        else {
                            echo "<h1>Let's Seek Validation!</h1>";
                        }
                    }
                    else {
                        echo "<h1>Let's Seek Validation!</h1>";
                    }
                ?>
                <hr class="mt-5 mb-5">

                <div class="d-flex justify-content-center">
                    <form action="process.php" method="POST">
                        Email: <span class="required">*</span>
                        <input type="text" name="email" placeholder="iloveketchup@msn.com" class="full-width" value="<?php if (!empty($_GET['em'])) echo $_GET['em']; ?>">
                        Phone Number: <span class="required">*</span>
                        <input type="text" name="number" placeholder="(555) 555-5555" class="full-width" value="<?php if (!empty($_GET['nm'])) echo $_GET['nm']; ?>">

                        <div class="d-flex justify-content-center mt-5">
                            <input class="btn-grey bg-nav btn-rnd" type="submit"><pre> </pre><input class="btn-grey bg-nav btn-rnd"type="reset">
                        </div>
                    </form>
                </div>

            </div>
        </div>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>