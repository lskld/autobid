/** @type {import('tailwindcss').Config} */
module.exports = {
	// NOTE: Update this to include the paths to all files that contain Nativewind classes.
	content: ["./src/**/*.{js,jsx,ts,tsx}"],
	presets: [require("nativewind/preset")],
	darkMode: 'class',
	theme: {
		extend: {
			// Font family - references CSS variable
			fontFamily: {
				sans: ['var(--font-sans)'],
			},
			// All colors reference CSS variables defined in global.css
			// When .dark class is applied, CSS variables automatically switch
			colors: {
				// Backgrounds
				bg: "var(--color-bg)",
				surface: "var(--color-surface)",
				background: "var(--color-background)",
				backgroundElement: "var(--color-backgroundElement)",
				backgroundSelected: "var(--color-backgroundSelected)",
				
				// Text
				text: "var(--color-text)",
				textSecondary: "var(--color-textSecondary)",
				primary: "var(--color-primary)",
				secondary: "var(--color-secondary)",
				
				// Accents
				accent: "var(--color-accent)",
				"accent-2": "var(--color-accent-2)",
				"accent-3": "var(--color-accent-3)",
				
				// Semantic
				success: "var(--color-success)",
				error: "var(--color-error)",
				warning: "var(--color-warning)",
			},
		},
	},
	plugins: [],
};
