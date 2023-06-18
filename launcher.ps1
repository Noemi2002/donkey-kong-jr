Add-Type -assembly System.Windows.Forms

$main_form = New-Object System.Windows.Forms.Form
$main_form.Text ='KongJr Launcher'

$main_form.Width = 400
$main_form.Height = 300
$main_form.FormBorderStyle = [System.Windows.Forms.FormBorderStyle]::FixedSingle
$main_form.MaximizeBox = $false

$Label = New-Object System.Windows.Forms.Label
$Label.Text = "KongJr Launcher"
$Label.Location  = New-Object System.Drawing.Point(145, [int]($main_form.Height / 2 - 60))
$Label.AutoSize = $true
$main_form.Controls.Add($Label)


$Button = New-Object System.Windows.Forms.Button
$Button.Text = "Start Game"

$Button.Location = New-Object System.Drawing.Point(150, [int]($main_form.Height / 2))

function Get-ScriptExecutionPath {
    $scriptPath = $PSScriptRoot
    return $scriptPath
}

# Example usage
$currentPath = Get-ScriptExecutionPath

$Button.Add_Click({
    # Specify the paths to the files
    $serverJarPath = $currentPath.ToString() + "/server/out/artifacts/KongJrServer/KongJrServer.jar"
    $clientExePath = $currentPath.ToString() + "/cmake-build-debug/Client.exe"

    Write-Host "Concatenated path: $clientExePath"

    # Execute the commands
    Start-Process -FilePath "java" -ArgumentList "-jar $serverJarPath"
    Start-Process -FilePath $clientExePath
})

# Add UI Element to the root form
$main_form.Controls.Add($Button)

# Run the window main loop
$main_form.ShowDialog()