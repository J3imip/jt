use eframe::egui;

const GAMMA: f64 = 0.5772156649;

struct MyApp {
    input_value: String,
    result: i32,
    error_message: String,
}

impl eframe::App for MyApp {
    fn update(&mut self, ctx: &egui::Context, _frame: &mut eframe::Frame) {
        egui::CentralPanel::default().show(ctx, |ui| {
            ui.heading("Compute Product of Series (1 + 1/k)");

            ui.label("Enter the number of terms N:");
            ui.text_edit_singleline(&mut self.input_value);

            if ui.button("Compute").clicked() {
                match self.input_value.trim().parse::<usize>() {
                    Ok(n) if n > 0 && n < i32::MAX as usize => {
                        self.result = calculate_series_product(n as i32);
                        self.error_message.clear();
                    }
                    _ => {
                        self.result = 0;
                        self.error_message = "Invalid input. Please enter a positive integer.".to_string();
                    }
                }
            }

            ui.label(format!("Result: {}", self.result));
            if !self.error_message.is_empty() {
                ui.colored_label(egui::Color32::RED, &self.error_message);
            }
        });
    }
}

fn main() -> eframe::Result<()> {
    let native_options = eframe::NativeOptions {
        viewport: egui::ViewportBuilder::default().with_inner_size([300.0, 200.0]),
        ..Default::default()
    };

    eframe::run_native(
        "Product Series App",
        native_options,
        Box::new(|_cc| {
            Ok(Box::new(MyApp {
                input_value: "10".to_owned(),
                result: 0,
                error_message: String::new(),
            }))
        }),
    )
}

fn calculate_series_product(terms: i32) -> i32 {
    terms + 1
}
