<?php
    $e = "v2fBmTtpB";

    if(!empty($_POST['email']) && !empty($_POST['number'])){
        $pattern1 = '~^\([0-9]{3}\)[- ][0-9]{3}-[0-9]{4}$~';
        $pattern2 = '/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$/';

            if(preg_match($pattern1, $_POST['number']) && preg_match($pattern2, $_POST['email'])){
                function displayInfo(){
                    $msg = "";
                    $msg .= "Email: $_POST[email]<br>";
                    $msg .= "Phone: $_POST[number]";
                
                    return $msg;
                }
            }
        
            else if(!preg_match($pattern1, $_POST['number']) && preg_match($pattern2, $_POST['email'])){
                $e = "euKFwpN4N";
            }
            else if(preg_match($pattern1, $_POST['number']) && !preg_match($pattern2, $_POST['email'])){
                $e = "Qn0tMjWzE";
            }
            else {
                header("Location: index.php?em=$_POST[email]&nm=$_POST[number]&er=$e");
            }
    }
    else if(!empty($_POST['email']) && empty($_POST['number'])){
        $e = "euKFwpN4N";
        header("Location: index.php?em=$_POST[email]&er=$e");
    }
    else if(empty($_POST['email']) && !empty($_POST['number'])){
        $e = "Qn0tMjWzE";
        header("Location: index.php?nm=$_POST[number]&er=$e");
    }
    else{
        header("Location: index.php?er=$e");
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
        <?php echo displayNavMenu(); ?>
        
        <div class="container">
            <div class="jumbotron">
                <h1>Thank You!</h1>
                <hr>
                <h3>Your Contact Info:</h3>
                <?php
                    echo displayInfo();
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
