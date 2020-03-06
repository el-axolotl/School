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
        <?php echo displayNavMenu(); ?>
        
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