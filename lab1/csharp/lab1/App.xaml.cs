namespace lab1;

public partial class App : Application
{
    public App()
    {
        InitializeComponent();
    }

    protected override Window CreateWindow(IActivationState? activationState)
    {
        return new Window(new MainPage())
        {
            MinimumHeight = 500,
            MinimumWidth = 400,
            MaximumHeight = 500,
            MaximumWidth = 400
        };
    }
}