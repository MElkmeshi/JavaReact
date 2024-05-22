import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vitejs.dev/config/
export default defineConfig({
  define: {
    global: {},
  },
  plugins: [react()],
  build: {
    outDir: "../backend/src/main/resources/static",
  },
  server: {
    port: 3030,
  },
});
