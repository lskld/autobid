export const colors = {
  background: "#0E1319",
  surface: "#151C24",
  textPrimary: "#E8E4DC",
  textSecondary: "#8A94A0",
  accentPrimary: "#E8703A",
  accentSecondary: "#D9A441",
  accentTertiary: "#4E9B8F",
  success: "#5FA860",
  error: "#D9544A",
  warning: "#E0A93E",
} as const;

export type Colors = typeof colors;