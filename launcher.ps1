Add-Type -AssemblyName System.Windows.Forms

# Create a new form
$form = New-Object System.Windows.Forms.Form
$form.Text = "Donkey Kong Jr Launcher"
$form.Size = New-Object System.Drawing.Size(400, 200)
$form.FormBorderStyle = "FixedSingle"
$form.MaximizeBox = $false

# Create a button
$button = New-Object System.Windows.Forms.Button
$button.Text = "Start Game"
$button.Location = New-Object System.Drawing.Point(150, 80)
$button.Size = New-Object System.Drawing.Size(100, 30)
$button.Add_Click({
    # Specify the paths to the files
    $serverJarPath = "server/out/artifacts/KongJrServer/KongJrServer.jar"
    $clientExePath = "cmake-build-debug/Client.exe"

    # Execute the commands
    Start-Process -FilePath "java" -ArgumentList "-jar $serverJarPath"
    Start-Process -FilePath $clientExePath
})

# Add the button to the form
$form.Controls.Add($button)

# Show the form
$form.ShowDialog()
