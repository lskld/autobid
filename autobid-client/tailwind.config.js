/** @type {import('tailwindcss').Config} */
module.exports = {
	// NOTE: Update this to include the paths to all files that contain Nativewind classes.
	content: ["./src/**/*.{js,jsx,ts,tsx}"],
	presets: [require("nativewind/preset")],
	theme: {
		extend: {
			colors: {
				bg: "#0E1319",
				surface: "#151C24",
				primary: "#E8E4DC",
				secondary: "#8A94A0",
				accent: "#E8703A",
				"accent-2": "#D9A441",
				"accent-3": "#4E9B8F",
				success: "#5FA860",
				error: "#D9544A",
				warning: "#E0A93E",
			},
		},
	},
	plugins: [],
};
