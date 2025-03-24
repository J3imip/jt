using System.Globalization;
using lab1.Services;

namespace lab1;

public partial class MainPage : ContentPage
{
    public MainPage()
    {
        InitializeComponent();
    }

    private void OnCalculateClicked(object sender, EventArgs e)
    {
        if (int.TryParse(InputEntry.Text, out var terms))
        {
            if (terms <= 0)
            {
                ResultLabel.Text = "Please enter a number greater than zero.";
                return;
            }

            var result = MathService.CalculateSeriesProduct(terms);

            var resultStr = result.ToString(CultureInfo.InvariantCulture);
            var userInput = terms.ToString();

            var formatted = new FormattedString();
            for (var i = 0; i < resultStr.Length; i++)
            {
                var resultDigit = resultStr[i];
                char? inputDigit = i < userInput.Length ? userInput[i] : null;

                var span = new Span { Text = resultDigit.ToString() };

                if (inputDigit == null || resultDigit != inputDigit)
                {
                    span.TextColor = Color.FromArgb("#B69DF8");
                    span.FontAttributes = FontAttributes.Bold;
                }

                formatted.Spans.Add(span);
            }

            ResultLabel.FormattedText = formatted;
            return;
        }

        ResultLabel.Text = "Please enter a valid positive number.";
    }
}