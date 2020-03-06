<?php
    $isError = false;
    $err = "All fields with a * are required";

    $bands = array("Red Hot Chili Peppers", "Sublime", "Slipknot", "Disturbed", "Bob Marley");
    $colors = array("Black", "Red", "Green", "White", "Blue");
    $sizes = array("XS", "S", "M", "L", "XL");
    $styles = array("Polo", "T-Shirt", "Long Sleeve", "Slim Fit", "Hoodie");

    if(!empty($_GET)){
        $isError = true;
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

        <div class="container box">
            <div class="d-flex justify-content-center">
                <a href="index.php" class="mt-5 mb-5">Back</a>
            </div>

            <hr class="mb-5">
            
            
            <div class="d-flex justify-content-center">
                <form action="order.php" method="POST">
                
                    <?php
                        if($isError){
                            echo "<p class='required'>$err</p><br>";
                        }
                    ?>

                    <div class="full-width">
                        <h2 class="contact bg-nav">SELECT AN ITEM</h2>
                    </div>

                    <!--BAND-->
                    <div class="d-flex justify-content-center mb-3">
                        <span class="required">*</span>
                        <select name="band" class="full-width" required>
                            <?php
                                if(!empty($_GET['band'])){
                                    echo "<option selected value=$_GET[band]>$_GET[band]</option>";
                                }
                                else{
                                    echo "<option selected disabled hidden>Band</option>";
                                }
                                foreach ($bands as $band){
                                    echo "<option value=\"$band\">$band</option>";
                                }
                            ?>
                        </select>
                    </div>
                    <!--BAND END-->

                    <!--COLOR-->
                    <div class="d-flex justify-content-center mb-3">
                        <span class="required">*</span>
                        <select name="color" class="full-width">
                            <?php
                                if(!empty($_GET['color'])){
                                    echo "<option selected value=$_GET[color]>$_GET[color]</option>";
                                }
                                else{
                                    echo "<option selected disabled hidden>Color</option>";
                                }
                                foreach ($colors as $color){
                                    echo "<option value=\"$color\">$color</option>";
                                }
                            ?>
                        </select>
                    </div>
                    <!--COLOR END-->

                    <!--SIZE-->
                    <div class="d-flex justify-content-center mb-3">
                        <span class="required">*</span>
                        <select name="size" class="full-width">
                            <?php
                                if(!empty($_GET['size'])){
                                    echo "<option selected value=$_GET[size]>$_GET[size]</option>";
                                }
                                else{
                                    echo "<option selected disabled hidden>Size</option>";
                                }
                                foreach ($sizes as $size){
                                    echo "<option value=\"$size\">$size</option>";
                                }
                            ?>
                        </select>
                    </div>
                    <!--SIZE END-->

                    <!--STYLE-->
                    <div class="d-flex justify-content-center">
                        <span class="required">*</span>
                        <select name="style" class="full-width">
                            <?php
                                if(!empty($_GET['style'])){
                                    echo "<option selected value=$_GET[style]>$_GET[style]</option>";
                                }
                                else{
                                    echo "<option selected disabled hidden>Style</option>";
                                }
                                foreach ($styles as $style){
                                    echo "<option value=\"$style\">$style</option>";
                                }
                            ?>
                        </select>
                    </div>
                    <!--STYLE END-->

                    <hr class="mt-5 mb-5">

                    <div class="full-width">
                        <h2 class="contact bg-nav">CONTACT INFO</h2>
                    </div>
                    Full Name: <span class="required">*</span><br>
                    <input type="text" name="firstName" placeholder="First" class="rest-width" value="<?php if (!empty($_GET['firstName'])) echo $_GET['firstName']; ?>">
                    <input type="text" name="lastName" placeholder="Last" class="half-width" value="<?php if (!empty($_GET['lastName'])) echo $_GET['lastName']; ?>">
                    Email: <span class="required">*</span><br>
                    <input type="text" name="email" class="full-width" value="<?php if (!empty($_GET['email'])) echo $_GET['email']; ?>">
                    Telephone: <span class="required">*</span><br>
                    <input type="text" name="telephone" class="full-width" value="<?php if (!empty($_GET['telephone'])) echo $_GET['telephone']; ?>">
                    Address 1: <span class="required">*</span><br>
                    <input type="text" name="address1" class="full-width" placeholder="Street Address" value="<?php if (!empty($_GET['address1'])) echo $_GET['address1']; ?>">
                    <input type="text" name="address2" class="full-width" placeholder="(Optional) Apt #" value="<?php if (!empty($_GET['address2'])) echo $_GET['address2']; ?>">
                    City: <span class="required">*</span><br>
                    <input type="text" name="city" class="full-width" value="<?php if (!empty($_GET['city'])) echo $_GET['city']; ?>">
                    State / Province / Region: <span class="required">*</span><br>
                    <input type="text" name="state" class="full-width" value="<?php if (!empty($_GET['state'])) echo $_GET['state']; ?>">
                    Postal Code: <span class="required">*</span><br>
                    <input type="text" name="postal_code" class="full-width" value="<?php if (!empty($_GET['postal_code'])) echo $_GET['postal_code']; ?>">
                    <br><br>

                    <div class="container d-flex justify-content-center mb-5">
                        <input type="submit" class="btn-grey bg-nav btn-rnd"><pre> </pre><input type="reset" class="btn-grey bg-nav btn-rnd">
                    </div>
                </form>
            </div>

        </div>



        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>