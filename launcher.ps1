Add-Type -assembly System.Windows.Forms

$main_form = New-Object System.Windows.Forms.Form
$main_form.Text ='KongJr Launcher'

$main_form.Width = 600
$main_form.Height = 400


$Label = New-Object System.Windows.Forms.Label
$Label.Text = "KongJr Launcher"
$Label.Location  = New-Object System.Drawing.Point(0,10)
$Label.AutoSize = $true
$main_form.Controls.Add($Label)

# Run the java executable from 



# Run the command  .\cmake-build-debug\Client.exe
$Button = New-Object System.Windows.Forms.Button
$Button.Text = "Run"

$Button.Location = New-Object System.Drawing.Point(0, 50)

$Button.Add_Click({& .\cmake-build-debug\Client.exe})



# Add UI Element to the root form
$main_form.Controls.Add($Button)

# Run the window main loop
$main_form.ShowDialog()