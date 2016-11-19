<?php
if(empty($_GET['id'])){header('Location: /?view=home');die();} 
include($DIR.'myconnect.php');

	$q=$mysqli->query("SELECT * FROM events WHERE event_id = '".$mysqli->real_escape_string($_GET['id'])."' LIMIT 1");
	$assoc=$q->fetch_assoc();
	if(empty($assoc)){header('Location: /?view=home');die();}
$cmm_op.='
        <!-- Page Title -->
        <div class="page-title-container">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 wow fadeIn">
                        <i class="fa fa-tasks"></i>
                        <h1>'.$assoc['event_name'].'</h1>
                        <p>Co-ordinator Detail -'.$assoc['event_cdetail'].'</p>
                        
                    </div>
                </div>
            </div>
        </div>
       <!--Half Width Text -->
        <div class="services-half-width-container">
        	<div class="container">
	            <div class="row">
	                <div class="col-sm-6 services-half-width-text wow fadeInUp">
	                    <h2>Rules for '.$assoc['event_name'].' event</h2>

	                </div>
	            </div>
	        
      <div class="col-sm-12 about-us-text wow fadeInLeft animated" style="visibility: visible; animation-name: fadeInLeft;">
	                    <h2>Rounds Detail</h2>
  ';if($assoc['event_round1']!="") $cmm_op.='<h3>Rounds 1 - <strong>'.$assoc['event_round1'].'</strong></h3>';
if($assoc['event_round2']!="") $cmm_op.='<h3>Rounds 1 - <strong>'.$assoc['event_round2'].'</strong></h3>';
if($assoc['event_round3']!="") $cmm_op.='<h3>Rounds 1 - <strong>'.$assoc['event_round3'].'</strong></h3>';
if($assoc['event_round4']!="") $cmm_op.='<h3>Rounds 1 - <strong>'.$assoc['event_round4'].'</strong></h3>';
$cmm_op.='<h2><strong>Rules/Requirements                    	                
</strong></h2>
 
 ';
 if($assoc['event_round1']!="")$cmm_op.='<h3>Round 1</h3>';
 $cmm_op.='<ul>';
if($assoc['event_role1']!="") $cmm_op.=$assoc['event_role1'];
$cmm_op.='</ul>';

  if($assoc['event_round2']!="")$cmm_op.='<h3>Round 2</h3>
';
 $cmm_op.='<ul>';

if($assoc['event_role2']!="") $cmm_op.=$assoc['event_role2'];
 $cmm_op.='</ul>';

  if($assoc['event_round3']!="")$cmm_op.='<h3>Round 3</h3>';
   $cmm_op.='<ul>';

if($assoc['event_role3']!="") $cmm_op.=$assoc['event_role3'];
 $cmm_op.='</ul>';

  if($assoc['event_round4']!="")$cmm_op.='<h3>Round 4</h3>';
   $cmm_op.='<ul>';

if($assoc['event_role4']!="") $cmm_op.=$assoc['event_role4'];
 $cmm_op.='</ul>';

 $cmm_op.=' 
</div>
</div>
</div>
';
?>