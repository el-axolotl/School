<?php
    $pathName = $_SERVER['PHP_SELF'];
    $lastSlash = strrpos($pathName, '/') + 1;
    $lastPeriod = strrpos($pathName, '.');
    $pageName = substr($pathName, $lastSlash, $lastPeriod - $lastSlash);

    function displayHead()
    {
        global $pageName, $lastSlash;
    
        $head =
            "<!-- Required meta tags -->
            <meta charset=\"utf-8\">
            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
            
            <!-- Bootstrap CSS -->
            <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">
            <link rel=\"stylesheet\" href=";
        
        $head .= ($lastSlash < 11 ? "src/css/global_style.css>" : "../src/css/global_style.css>");
        $head .= "<title>";

        $head .= ($pageName == 'index' ? 'Home' : ucfirst($pageName));
        $head .= ' Page</title>';

        return $head;
    }

    function displayNavMenu()
    {
        global $lastSlash;
        
        $nav = "";
        $nav .= 
        '<nav class="navbar navbar-expand-md bg-nav">';
        $nav .= ($lastSlash < 11 ? 
            '<a href="index.php" class="navbar-brand"><img src="src/img/iconfinder_icon_animal_cachorro_3316536.png"></a>'
            :
            '<a href="../index.php" class="navbar-brand"><img src="../img/iconfinder_icon_animal_cachorro_3316536.png"></a>');

        $nav .= 
            '<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">CSIS 2440</a>

                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">';

        $nav .= ($lastSlash < 11 ? 
                            '<a class="dropdown-item" href="happy-birthday/index.php">Happy Birthday</a>
                            <a class="dropdown-item" href="music-database/index.php">Music Database</a>
                            <a class="dropdown-item" href="validation/index.php">Validation</a>' 
                            :
                            '<a class="dropdown-item" href="../happy-birthday/index.php">Happy Birthday</a>
                            <a class="dropdown-item" href="../music-database/index.php">Music Database</a>
                            <a class="dropdown-item" href="../validation/index.php">Validation</a>');
        
        $nav .= 
                        '</div>
                    </li>
                </ul>

                <div class="mr-3">
                    <form class="form-inline my-2 collapse navbar-collapse">
                        <input class="form-control mr-md-2" type="search" placeholder="Doesn\'t really search" aria-label="search">
                        <button class="btn btn-grey my-2" type="submit">Search</button>
                    </form>
                </div>   
            </div>
        </nav>';
        
        return $nav;
    }
?>