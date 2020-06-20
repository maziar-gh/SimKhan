<?php
    // Read $url and $sel from request ($_POST | $_GET)
	//$channel_name= 'chatr_kh';
		
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "html";
			
			
	$channel_name= @$_POST['cname'];
	$action= @$_POST['action'];
    $url = 'https://what.sapp.ir/'.$channel_name.'/';
    $sel = 'div[class="block"]';
    $go  = 'elements';
    $rm = strtoupper(getenv('REQUEST_METHOD') ?: $_SERVER['REQUEST_METHOD']);
    // var_export(compact('url', 'sel', 'go')+[$rm]+$_SERVER);
    if ( $rm == 'POST' ) {
        require_once __DIR__ . '/../hquery.php';

        $config = [
            'user_agent' => 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36',
            'accept_html' => 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
        ];

        // Enable cache
        hQuery::$cache_path = sys_get_temp_dir() . '/hQuery/';

        // Results acumulator
        $return = array();

        // If we have $url to parse and $sel (selector) to fetch, we a good to go
        if($url && $sel) {
            try {
                $doc = hQuery::fromUrl(
                    $url
                  , [
                        'Accept'     => $config['accept_html'],
                        'User-Agent' => $config['user_agent'],
                        'Upgrade-Insecure-Requests' => 1,
                    ]
                );
                if($doc) {
                    // Follow redirects
                    $t = $doc->href and $url = $t;

                    // Read some meta info from $doc
                    $t = $doc->find('head title') and $t = trim($t->text()) and $meta['title'] = $t;
                    $t = $doc->find('head meta');
                    if ( $t ) foreach($t as $k => $v) {
                        switch($v->attr('name')) {
                            case 'description': {
                                $t = trim($v->attr('content')) and $meta['description'] = $t;
                            } break;
                            case 'keywords': {
                                $t = trim($v->attr('content')) and $meta['keywords'] = $t;
                            } break;
                        }
                    }
                    if ( $t = $doc->headers ) {
                        $b = array();
                        foreach($t as $k => $v) $b[$k] = "$k: " . (is_array($v) ? implode(PHP_EOL, $v) : $v);
                        $meta['headers'] = $b = implode(PHP_EOL, $b);
                    }
                    $select_time = microtime(true);
                    $elements = $doc->find($sel);
                    $select_time = microtime(true) - $select_time;
                    $return['select_time'] = $select_time;
                    $return['elements_count'] = count($elements);
                }
                else {
                    $return['request'] = hQuery::$last_http_result;
                }
            }
            catch(Exception $ex) {
                $error = $ex;
            }
        }
		
		
		
				
				
    }
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf8" />
    <title>Process</title>
    <style lang="css">
        * {
            box-sizing: border-box;
        }
        html, body {
            position: relative;
            min-height: 100%;
        }
        header, section {
            margin: 10px auto;
            padding: 10px;
            width: 90%;
            max-width: 1200px;
            border: 1px solid #eaeaea;
        }

        input {
            width: 100%;
        }
    </style>
</head>
<body>
    <header class="selector">
        <form name="hquery" action="" method="post">
            <p><label>نام کانال: <input type="text" name="cname" value="<?=htmlspecialchars(@$channel_name, ENT_QUOTES);?>" placeholder="نام کانال را وارد کنید" autofocus class="form-control" /></label></p>
            <p><label hidden>Selector: <input type="text" name="sel" value="<?=htmlspecialchars(@$sel, ENT_QUOTES);?>" placeholder="ex. 'a[href] &gt; img[src]:parent'" class="form-control" /></label></p>
            <p>
                <button type="submit" name="go" value="elements" class="btn btn-success" >بررسی کانال</button>
                <button type="submit" name="action" value="1" class="btn btn-success">آپدیت کانال ها</button>
            </p>
			
			<p>
				<textarea rows="6" cols="30"><?php 

				$all_channel = '';
				$list_channel = '';
				$filename = 'channels.dt';
				if(file_exists($filename)){
					//read
					$myfile = fopen($filename, "r") or die("Unable to open file!");
					$list_channel = fread($myfile,filesize($filename));
					$all_channel = (explode(" ",$list_channel));
					fclose($myfile);
				}else{
					//create
					$list_channel = 'خالی';
				}
				echo str_replace(' ',PHP_EOL, $list_channel);

				?></textarea>
			</p>

            <?php if( !empty($error) ): ?>
            <div class="error">
                <h3>Error:</h3>
                <p>
                    <?=$error->getMessage();?>
                </p>
            </div>
            <?php endif; ?>
        </form>
    </header>
	<center>
    <section class="result">
        <?php switch ($go) {
            case 'elements': if(!empty($elements)):?>
                <hr />
                <table style="width: 100%">
                    
                    <tbody>
            <?php 
			
			//img title dscription
			$cimage = '';
			$banners = $doc->find('div[class="col-md-2 col-sm-4"] img[src]');
			foreach($banners as $pos => $el):
				$cimage = htmlspecialchars($el->outerHtml());
			endforeach;
			$cimage = str_replace('<h1>','', str_replace('</h1>','', $el->outerHtml()));
			echo '<h1>'.$cimage.'</h1>';
			$cimage = substr($cimage, strpos($cimage, "src=") + 5);
			$cimage = str_replace('/>','', str_replace('" ','', $cimage));

			
			$cname = '';
			$banners = $doc->find('div[class="col-md-10 col-sm-8"] h1');
			foreach($banners as $pos => $el):
				$cname = htmlspecialchars($el->outerHtml());
			endforeach;
			$cname = str_replace('<h1>','', str_replace('</h1>','', $el->outerHtml()));
			$cname = str_replace('@','', $el->outerHtml());;

			echo '<h2>'.$cname.'</h2>';
			
			$dc = '';
			$banners = $doc->find('div[class="col-md-10 col-sm-8"] p');
			foreach($banners as $pos => $el):
				$dc = htmlspecialchars($el->outerHtml());
			endforeach;
			$dc = str_replace('<h1>','', str_replace('</h1>','', $el->outerHtml()));
			$dc = str_replace('@','', $el->outerHtml());;
			echo '<h4>'.$dc.'</h4>';
			
			

			// Create connection
			$conn = new mysqli($servername, $username, $password, $dbname);
			// Check connection
			if ($conn->connect_error) {
				die("Connection failed: " . $conn->connect_error);
			}
			$conn->query("SET character_set_results = 'utf8', character_set_client = 'utf8', character_set_connection = 'utf8', character_set_database = 'utf8', character_set_server = 'utf8'");
			
			
			// sql to create table
			$sql = 'CREATE TABLE tbl_'.clean($channel_name).' (
			id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
			cid VARCHAR(30) NOT NULL,
			html TEXT NOT NULL
			)';

			if ($conn->query($sql) === TRUE) {
				
				//file
				$filename = 'channels.dt';
				if(file_exists($filename)){
					//read
					$myfile = fopen($filename, "r") or die("Unable to open file!");
					$all = fread($myfile,filesize($filename));
					$all_channel = (explode(" ",$all));
					$txt = $all.' '.$channel_name;
					$myfile = fopen($filename, "w") or die("Unable to open file!");
					fwrite($myfile, $txt);
					fclose($myfile);
				}else{
					//create
					$myfile = fopen($filename, "w") or die("Unable to open file!");
					$txt = $channel_name;
					fwrite($myfile, $txt);
					fclose($myfile);
				}
				
				echo "Table MyGuests created successfully <br>";
				
				$tbl_name = 'tbl_'.strtolower(clean($channel_name));
				$qu = "INSERT INTO tbl_manage (cid, cname, img, description)
				VALUES ('$tbl_name', '$cname', '$cimage', '$dc');";
				
				if ($conn->query($qu) === TRUE) {
					echo "INSERT INTO successfully <br>";
				} else {
					echo "Error INSERT INTO tbl_manage: " . $conn->error;
				}
				
			} else {
				echo "Error creating table: " . $conn->error;
			}
			
			
			
			
			
			
			
			
			$sql = '';
			$new_item = true;
			foreach($elements as $pos => $el):
				$p = trim($pos);
				$html = str_replace('\'','"',$el->outerHtml());
				$view = str_replace('\'','"',$el->outerHtml());
				
				$sql .= "INSERT INTO tbl_".clean($channel_name)." (cid, html)
				VALUES ('$channel_name.$p', '$html');";
				

				$query = "SELECT cid FROM tbl_".clean($channel_name)." WHERE cid='$channel_name.$p'";
				if ($result = $conn -> query($query)) {
					$row = $result -> fetch_row();
					if( count($row) > 0){
						$new_item = false;
					}else{
						$new_item = true;
					}
					//echo count($row);
				}else{
					$new_item = true;
				}
				
				//break;
			endforeach;
			
			
			
			
			if ($new_item) {
				if ($conn->multi_query($sql) === TRUE) {
					echo "<h3><br>افزوده شد :) <br></h3>";
					
					echo '<br>زمان خواندن صفحه: '.$doc->read_time.'<br>';
					echo '<br>زمان تطبیق دادن صفحه: '.$doc->index_time.'<br>';
					echo '<br>اندازه سند: '.$doc->size.'<br>';
				} else {
					echo "Error: " . $sql . "<br>" . $conn->error;
				}
			}else{
				echo '<h3><br>محتوای جدیدی وجود ندارد :(<br></h3>';
				
				echo '<br>زمان خواندن صفحه: '.$doc->read_time.'<br>';
			echo '<br>زمان تطبیق دادن صفحه: '.$doc->index_time.'<br>';
			echo '<br>اندازه سند: '.$doc->size.'<br>';
				
			}
			
			
			


			$conn->close();
			?>
                        
            
                    </tbody>
                </table>
            <?php
            endif;
            break;

        } 
		
		
		
		
		
		
		function clean($string) {
		   $string = str_replace(' ', '_', $string); // Replaces all spaces with hyphens.
		   $string = str_replace('-', '_', $string);

		   return preg_replace('/[^A-Za-z0-9\-]/', '', $string); // Removes special chars.
		}
		
		
		
		
		
		?>
		
		<p><a href="https://maziardev.ir" target="_blank">maziardev.ir</a></p>
    </section>
	</center>
</p>
</body>
</html>
